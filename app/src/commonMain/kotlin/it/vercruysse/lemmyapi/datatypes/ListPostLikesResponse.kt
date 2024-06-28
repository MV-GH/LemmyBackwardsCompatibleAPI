package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListPostLikesResponse(
    val post_likes: List<VoteView>,
) : DatatypeRoot
