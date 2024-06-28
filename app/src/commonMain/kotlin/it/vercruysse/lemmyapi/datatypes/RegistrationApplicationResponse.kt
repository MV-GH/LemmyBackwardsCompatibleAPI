package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationResponse(
    val registration_application: RegistrationApplicationView,
) : DatatypeRoot
