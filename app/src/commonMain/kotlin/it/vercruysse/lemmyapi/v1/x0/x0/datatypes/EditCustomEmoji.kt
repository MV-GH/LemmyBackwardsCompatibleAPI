package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class EditCustomEmoji(
    val id: CustomEmojiId,
    val category: String? = null,
    val shortcode: String? = null,
    val image_url: DbUrl? = null,
    val alt_text: String? = null,
    val keywords: List<String>? = null,
)
