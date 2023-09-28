package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetSite(
    val auth: String? = null,
)
