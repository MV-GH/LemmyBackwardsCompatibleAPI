package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
    val violates_instance_rules: Boolean? = null,
)
