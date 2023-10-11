package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListRegistrationApplicationsResponse(
    val registration_applications: List<RegistrationApplicationView>,
)
