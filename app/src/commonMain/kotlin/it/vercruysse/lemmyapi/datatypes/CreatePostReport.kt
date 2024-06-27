package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
)
