package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListRegistrationApplicationsResponse(
    val registration_applications: List<RegistrationApplicationView>,
) : DatatypeRoot
