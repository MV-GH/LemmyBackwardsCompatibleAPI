package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolveObject(
    val q: String,
    val auth: String,
)
