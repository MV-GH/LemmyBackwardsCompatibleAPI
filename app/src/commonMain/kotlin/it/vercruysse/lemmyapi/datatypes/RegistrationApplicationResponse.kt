package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationResponse(
    val registration_application: RegistrationApplicationView,
)