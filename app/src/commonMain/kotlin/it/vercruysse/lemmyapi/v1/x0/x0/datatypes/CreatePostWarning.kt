package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

// TODO create UNI

@Serializable
internal data class CreatePostWarning(
    val post_id: PostId,
    val reason: String,
)
