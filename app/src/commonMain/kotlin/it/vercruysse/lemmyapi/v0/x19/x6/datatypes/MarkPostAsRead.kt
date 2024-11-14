package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkPostAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
)
