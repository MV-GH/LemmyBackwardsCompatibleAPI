package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmojiResponse(
    val custom_emoji: CustomEmojiView,
)
