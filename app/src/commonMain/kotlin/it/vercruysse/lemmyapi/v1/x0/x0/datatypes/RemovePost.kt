package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RemovePost(
    val post_id: PostId,
    val removed: Boolean,
    val reason: String? = null,
)
