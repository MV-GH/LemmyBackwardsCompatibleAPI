package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminListUsers(
    val banned_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    // TODO: AdminListSortType
    val sort: String? /* "new" | "old" */ = null,
    val limit: Long? = null,
)
