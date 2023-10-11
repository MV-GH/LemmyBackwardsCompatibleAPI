package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class CreateCustomEmoji(
    val category: String,
    val shortcode: String,
    val image_url: String,
    val alt_text: String,
    val keywords: List<String>,
)
