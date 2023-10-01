package pictrs.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class UploadImage(
    val auth: String? = null,
    val images: List<ByteArray>,
)
