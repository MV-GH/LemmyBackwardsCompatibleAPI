package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MarkPostAsRead(
    val post_ids: List<PostId>,
    val read: Boolean,
)
