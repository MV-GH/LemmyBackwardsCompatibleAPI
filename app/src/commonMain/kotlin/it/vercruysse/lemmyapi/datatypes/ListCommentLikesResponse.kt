package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListCommentLikesResponse(
    val comment_likes: List<VoteView>,
) : DatatypeRoot
