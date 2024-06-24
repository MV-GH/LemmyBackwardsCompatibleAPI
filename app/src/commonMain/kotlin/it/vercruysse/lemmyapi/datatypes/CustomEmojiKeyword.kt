package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CustomEmojiKeyword(
    val custom_emoji_id: CustomEmojiId,
    val keyword: String,
)
