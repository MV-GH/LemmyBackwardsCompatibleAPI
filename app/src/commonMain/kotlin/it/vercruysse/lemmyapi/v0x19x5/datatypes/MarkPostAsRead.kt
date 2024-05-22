package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPostAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
)
