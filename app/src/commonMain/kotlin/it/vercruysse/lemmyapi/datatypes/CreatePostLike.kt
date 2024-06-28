package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class CreatePostLike(
    val post_id: PostId,
    val score: Int,
) : DatatypeRoot
