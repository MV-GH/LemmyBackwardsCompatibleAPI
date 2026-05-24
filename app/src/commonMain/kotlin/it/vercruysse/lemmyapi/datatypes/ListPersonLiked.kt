package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PersonContentType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ListPersonLiked(
    val type_: PersonContentType? /* "all" | "comments" | "posts" */ = null,
    val like_type: String? /* "all" | "liked_only" | "disliked_only" */ = null,
    val page_cursor: PaginationCursor? = null,
    val limit: Long? = null,
) : DatatypeRoot
