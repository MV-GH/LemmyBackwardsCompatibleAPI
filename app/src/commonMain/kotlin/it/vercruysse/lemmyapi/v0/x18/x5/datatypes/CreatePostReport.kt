package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
    val auth: String,
)
