package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCustomEmoji(
    val category: String,
    val shortcode: String,
    val image_url: String,
    val alt_text: String,
    val keywords: List<String>,
)
