package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
)
