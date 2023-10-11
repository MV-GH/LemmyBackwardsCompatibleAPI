package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationResponse(
    val registration_application: RegistrationApplicationView,
)
