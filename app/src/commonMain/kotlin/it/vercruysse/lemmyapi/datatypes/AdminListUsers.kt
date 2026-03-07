package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.LocalUserSortType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AdminListUsers(
    val banned_only: Boolean? = null,
    val page_cursor: PaginationCursor? = null,
    val sort: LocalUserSortType? /* "new" | "old" */ = null,
    val limit: Long? = null,
) : DatatypeRoot
