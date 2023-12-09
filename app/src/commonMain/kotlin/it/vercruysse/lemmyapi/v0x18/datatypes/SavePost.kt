package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SavePost(
    val post_id: PostId,
    val save: Boolean,
    val auth: String,
)
