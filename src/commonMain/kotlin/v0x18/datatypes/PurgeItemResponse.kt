package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgeItemResponse(
    val success: Boolean,
)
