package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteCustomEmoji(
    val id: CustomEmojiId,
    val auth: String,
)
