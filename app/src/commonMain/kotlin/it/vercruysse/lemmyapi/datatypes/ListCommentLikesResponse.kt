package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentLikesResponse(
    val comment_likes: List<VoteView>,
)
