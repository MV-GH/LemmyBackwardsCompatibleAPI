package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteCustomEmojiResponse(
    val id: CustomEmojiId,
    val success: Boolean,
)
