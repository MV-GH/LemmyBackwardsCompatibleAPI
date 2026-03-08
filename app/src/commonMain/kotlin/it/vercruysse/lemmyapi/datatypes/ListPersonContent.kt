package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PersonContentType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonContent(
    val type_: PersonContentType? /* "all" | "comments" | "posts" */ = null,
    val person_id: PersonId? = null,
    val username: String? = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
): DatatypeRoot
