package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmojiView(
    val custom_emoji: CustomEmoji,
    val keywords: List<CustomEmojiKeyword>,
)
