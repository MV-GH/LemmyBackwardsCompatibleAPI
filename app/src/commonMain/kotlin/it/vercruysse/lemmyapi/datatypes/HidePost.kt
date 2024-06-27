package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class HidePost(
    val post_ids: List<PostId>,
    val hide: Boolean,
)
