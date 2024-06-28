package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadRegistrationApplicationCountResponse(
    val registration_applications: Long,
) : DatatypeRoot
