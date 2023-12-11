package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkPostAsRead(
    val post_id: PostId,
    val read: Boolean,
    val auth: String,
)
