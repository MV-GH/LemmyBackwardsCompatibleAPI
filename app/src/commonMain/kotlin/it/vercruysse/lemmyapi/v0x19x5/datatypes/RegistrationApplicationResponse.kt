package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplicationResponse(
    val registration_application: RegistrationApplicationView,
)
