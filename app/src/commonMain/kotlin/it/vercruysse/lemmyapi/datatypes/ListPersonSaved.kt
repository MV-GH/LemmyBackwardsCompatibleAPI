package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonSaved(
    val type_: String? /* "All" | "Comments" | "Posts" */ = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
): DatatypeRoot
