package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmojiKeyword(
    val custom_emoji_id: CustomEmojiId,
    val keyword: String,
)
