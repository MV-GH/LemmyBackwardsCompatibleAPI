package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListRegistrationApplicationsResponse(
    val registration_applications: List<RegistrationApplicationView>,
)
