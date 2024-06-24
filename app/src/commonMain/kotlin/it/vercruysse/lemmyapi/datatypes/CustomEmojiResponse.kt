package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiResponse(
    val custom_emoji: CustomEmojiView,
)
