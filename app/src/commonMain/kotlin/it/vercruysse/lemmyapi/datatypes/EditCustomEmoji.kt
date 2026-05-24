package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class EditCustomEmoji(
    val id: CustomEmojiId,
    val category: String? = null,
    val shortcode: String? = null,
    val image_url: String? = null,
    val alt_text: String? = null,
    val keywords: List<String>? = null,
) : DatatypeRoot
