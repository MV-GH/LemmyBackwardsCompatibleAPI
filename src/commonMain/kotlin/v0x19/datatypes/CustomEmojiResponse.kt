package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiResponse(
    val custom_emoji: CustomEmojiView,
)
