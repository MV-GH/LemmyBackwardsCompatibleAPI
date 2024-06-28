package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetPost(
    val id: PostId? = null,
    val comment_id: CommentId? = null,
) : DatatypeRoot
