package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonContent(
    val type_: ListingType? /* "All" | "Comments" | "Posts" */ = null,
    val person_id: PersonId? = null,
    val username: String? = null,
    val page_cursor: PaginationCursor? = null,
    val page_back: Boolean? = null,
    val limit: Long? = null,
): DatatypeRoot
