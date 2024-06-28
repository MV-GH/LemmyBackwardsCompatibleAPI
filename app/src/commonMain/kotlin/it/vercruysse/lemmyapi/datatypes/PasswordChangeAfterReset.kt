package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PasswordChangeAfterReset(
    val token: String,
    val password: String,
    val password_verify: String,
) : DatatypeRoot
