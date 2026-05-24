package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CustomEmoji(
    val id: CustomEmojiId,
    val shortcode: String,
    val image_url: String,
    val alt_text: String,
    val category: String,
    val published_at: String,
    val updated_at: String? = null,
) : DatatypeRoot
