package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonContent(
    // TODO: custom enum
    val type_: String? /* "all" | "comments" | "posts" */ = null,
    val person_id: PersonId? = null,
    val username: String? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
): DatatypeRoot
