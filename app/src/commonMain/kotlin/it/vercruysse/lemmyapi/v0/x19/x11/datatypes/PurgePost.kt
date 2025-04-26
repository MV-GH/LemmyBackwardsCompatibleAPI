package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PurgePost(
    val post_id: PostId,
    val reason: String? = null,
)
