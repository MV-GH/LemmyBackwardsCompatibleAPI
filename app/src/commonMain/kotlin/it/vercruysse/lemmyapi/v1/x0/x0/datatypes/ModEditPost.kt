package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModEditPost(
    val post_id: PostId,
    val nsfw: Boolean? = null,
    val tags: List<TagId>? = null,
)
