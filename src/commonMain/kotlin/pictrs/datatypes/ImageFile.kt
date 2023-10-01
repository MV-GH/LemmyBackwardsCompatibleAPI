package pictrs.datatypes

import kotlinx.serialization.Serializable
@Serializable
data class ImageFile(
    val file: String,
    val delete_token: String,
    /**
     * Set manually based on the above info, for convenience
     */
    val url: String? = null,
    val delete_url: String? = null,
)
