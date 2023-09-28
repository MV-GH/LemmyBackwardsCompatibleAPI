package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationResponse(
    val registration_application: RegistrationApplicationView,
)
