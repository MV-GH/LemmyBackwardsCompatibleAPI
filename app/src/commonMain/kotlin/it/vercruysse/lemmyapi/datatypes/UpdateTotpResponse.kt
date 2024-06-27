package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class UpdateTotpResponse(
    val enabled: Boolean,
)
