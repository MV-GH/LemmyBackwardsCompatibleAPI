package pictrs.datatypes

import kotlinx.serialization.Serializable
@Serializable
data class DeleteImage(
    val delete_token: String,
    val filename: String,
)
