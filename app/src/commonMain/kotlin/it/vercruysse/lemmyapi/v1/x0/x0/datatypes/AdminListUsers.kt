package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.LocalUserSortType
import kotlinx.serialization.Serializable

@Serializable
internal data class AdminListUsers(
    val banned_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val sort: LocalUserSortType? /* "new" | "old" */ = null,
    val limit: Long? = null,
)
