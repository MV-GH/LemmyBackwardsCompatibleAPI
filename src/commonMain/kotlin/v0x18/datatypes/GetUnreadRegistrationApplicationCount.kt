package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadRegistrationApplicationCount(
    val auth: String,
)
