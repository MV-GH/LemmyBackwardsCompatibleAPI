package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PurgeItemResponse(
    val success: Boolean,
)
