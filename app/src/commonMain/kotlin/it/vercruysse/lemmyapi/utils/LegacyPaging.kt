package it.vercruysse.lemmyapi.utils

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.datatypes.PagedResponse
import it.vercruysse.lemmyapi.datatypes.PaginationCursor
import it.vercruysse.lemmyapi.exception.LemmyBadRequestException

/**
 * Emulates cursor pagination on top of the page-based pagination of pre 1.0 Lemmy.
 *
 * The synthetic cursor is an opaque string that encodes the page number. Consumers should
 * only pass back cursors they received from [PagedResponse.next_page] / [PagedResponse.prev_page]
 * of the same instance.
 */
internal object LegacyPaging {
    private const val PREFIX = "p:"
    const val INVALID_CURSOR_ERROR = "invalid_page_cursor"

    /**
     * Decodes a synthetic cursor into a 1-based page number. A `null` cursor means the first page.
     */
    fun decode(cursor: PaginationCursor?): Result<Long> {
        if (cursor == null) return Result.success(1L)
        val page = cursor.takeIf { it.startsWith(PREFIX) }
            ?.removePrefix(PREFIX)
            ?.toLongOrNull()
            ?.takeIf { it >= 1 }
        return if (page != null) {
            Result.success(page)
        } else {
            Result.failure(LemmyBadRequestException(400, INVALID_CURSOR_ERROR, "Not a legacy page cursor: $cursor"))
        }
    }

    fun encode(page: Long): PaginationCursor = "$PREFIX$page"

    /** The cursor to the page after [page]. Given whenever the page is not empty, as the server default limit is not known. */
    fun next(page: Long, hasItems: Boolean): PaginationCursor? = if (hasItems) encode(page + 1) else null

    /** The cursor to the page before [page], null on the first page. */
    fun prev(page: Long): PaginationCursor? = if (page > 1) encode(page - 1) else null

    /**
     * Decodes [cursor] and runs [fetch] with the page number, failing without calling [fetch] on an invalid cursor.
     */
    suspend fun <R> withPage(
        cursor: PaginationCursor?,
        fetch: suspend (page: Long) -> Result<R>,
    ): Result<R> {
        val page = decode(cursor).getOrElse { return Result.failure(it) }
        return fetch(page)
    }

    /**
     * Fetches the page encoded in [cursor] and wraps the result in a [PagedResponse] with synthetic cursors.
     */
    suspend fun <T : DatatypeRoot> paged(
        cursor: PaginationCursor?,
        fetch: suspend (page: Long) -> Result<List<T>>,
    ): Result<PagedResponse<T>> = pagedResponse(cursor) { page -> fetch(page).map { PagedResponse(it) } }

    /**
     * Like [paged], for fetches that already build a [PagedResponse], for example by combining several requests.
     * Its cursors are replaced by synthetic ones.
     *
     * [filter] is applied after the cursors are set, so a page that is filtered down to nothing doesn't end the paging.
     */
    suspend fun <T : DatatypeRoot> pagedResponse(
        cursor: PaginationCursor?,
        filter: (T) -> Boolean = { true },
        fetch: suspend (page: Long) -> Result<PagedResponse<T>>,
    ): Result<PagedResponse<T>> = withPage(cursor) { page ->
        fetch(page).map { it.copy(items = it.items.filter(filter), next_page = next(page, it.items.isNotEmpty()), prev_page = prev(page)) }
    }
}
