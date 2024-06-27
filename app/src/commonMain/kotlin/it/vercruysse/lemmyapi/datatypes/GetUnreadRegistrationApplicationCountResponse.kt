package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadRegistrationApplicationCountResponse(
    val registration_applications: Long,
)
