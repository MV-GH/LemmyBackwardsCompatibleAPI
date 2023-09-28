package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadRegistrationApplicationCountResponse(
    val registration_applications: Int,
)
