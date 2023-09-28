package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiKeyword(
    val id: Int,
    val custom_emoji_id: CustomEmojiId,
    val keyword: String,
)
