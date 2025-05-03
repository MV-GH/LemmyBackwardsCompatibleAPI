package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CustomEmoji(
    val id: CustomEmojiId,
    val shortcode: String,
    val image_url: DbUrl,
    val alt_text: String,
    val category: String,
    val published: String,
    val updated: String? = null,
)
