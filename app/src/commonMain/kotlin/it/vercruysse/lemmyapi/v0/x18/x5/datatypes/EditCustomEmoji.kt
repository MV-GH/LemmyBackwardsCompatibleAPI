package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditCustomEmoji(
    val id: CustomEmojiId,
    val category: String,
    val image_url: String,
    val alt_text: String,
    val keywords: List<String>,
    val auth: String,
)
