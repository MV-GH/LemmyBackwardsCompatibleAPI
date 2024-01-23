package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostLikesResponse(
    val post_likes: List<VoteView>,
)
