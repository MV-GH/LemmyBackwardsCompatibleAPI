package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SavePost(
    val post_id: PostId,
    val save: Boolean,
)
