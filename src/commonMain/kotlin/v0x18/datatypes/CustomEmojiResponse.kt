package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiResponse(
    val custom_emoji: CustomEmojiView,
)
