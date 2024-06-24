package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiView(
    val custom_emoji: CustomEmoji,
    val keywords: List<CustomEmojiKeyword>,
)
