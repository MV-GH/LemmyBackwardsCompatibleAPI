package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class EditCustomEmoji(
    val id: CustomEmojiId,
    val category: String,
    val image_url: String,
    val alt_text: String,
    val keywords: List<String>,
    val auth: String,
)
