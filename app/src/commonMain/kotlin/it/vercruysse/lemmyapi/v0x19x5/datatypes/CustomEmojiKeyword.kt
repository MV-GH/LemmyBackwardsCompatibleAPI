package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiKeyword(
    val custom_emoji_id: CustomEmojiId,
    val keyword: String,
)
