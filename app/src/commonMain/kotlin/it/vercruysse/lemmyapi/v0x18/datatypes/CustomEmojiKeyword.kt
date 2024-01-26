package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmojiKeyword(
    val id: Long,
    val custom_emoji_id: CustomEmojiId,
    val keyword: String,
)
