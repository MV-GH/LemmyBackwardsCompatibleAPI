package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmojiView(
    val custom_emoji: CustomEmoji,
    val keywords: List<CustomEmojiKeyword>,
)
