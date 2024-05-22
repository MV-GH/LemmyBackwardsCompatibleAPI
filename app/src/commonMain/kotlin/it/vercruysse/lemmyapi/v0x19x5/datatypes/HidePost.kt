package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class HidePost(
    val post_ids: List<PostId>,
    val hide: Boolean,
)
