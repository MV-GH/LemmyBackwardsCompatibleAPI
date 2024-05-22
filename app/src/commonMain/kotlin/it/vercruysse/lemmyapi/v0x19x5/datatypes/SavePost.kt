package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class SavePost(
    val post_id: PostId,
    val save: Boolean,
)
