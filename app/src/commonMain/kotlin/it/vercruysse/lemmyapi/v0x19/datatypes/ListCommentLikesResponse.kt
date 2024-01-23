package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListCommentLikesResponse(
    val comment_likes: List<VoteView>,
)
