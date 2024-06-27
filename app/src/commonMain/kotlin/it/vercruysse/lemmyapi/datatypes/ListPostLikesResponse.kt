package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPostLikesResponse(
    val post_likes: List<VoteView>,
)
