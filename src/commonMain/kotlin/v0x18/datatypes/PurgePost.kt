package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgePost(
    val post_id: PostId,
    val reason: String? = null,
    val auth: String,
)
