package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteCustomEmoji(
    val id: CustomEmojiId,
    val auth: String,
)
