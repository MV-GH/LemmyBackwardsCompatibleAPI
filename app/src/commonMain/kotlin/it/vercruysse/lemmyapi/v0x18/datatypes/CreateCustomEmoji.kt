package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCustomEmoji(
    val category: String,
    val shortcode: String,
    val image_url: String,
    val alt_text: String,
    val keywords: List<String>,
    val auth: String,
)
