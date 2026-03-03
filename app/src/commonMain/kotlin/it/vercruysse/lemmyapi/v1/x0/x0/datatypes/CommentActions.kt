package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

// TODO: Change
@Serializable
internal data class CommentActions(
    val voted_at: String? = null,
    val saved_at: String? = null,
    val vote_is_upvote: Boolean? = null,
)
