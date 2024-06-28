package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommentSortType
import kotlinx.serialization.Serializable

@Serializable
data class GetPersonMentions(
    val sort: CommentSortType? /* "Hot" | "Top" | "New" | "Old" | "Controversial" */ = null,
    val page: Long? = null,
    val limit: Long? = null,
    val unread_only: Boolean? = null,
) : DatatypeRoot
