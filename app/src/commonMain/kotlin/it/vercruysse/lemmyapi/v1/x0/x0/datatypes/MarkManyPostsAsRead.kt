package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MarkManyPostsAsRead(
    val post_ids: List<PostId>,
)
