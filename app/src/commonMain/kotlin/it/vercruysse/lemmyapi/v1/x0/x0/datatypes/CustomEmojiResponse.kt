package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmojiResponse(
    val custom_emoji: CustomEmojiView,
)
