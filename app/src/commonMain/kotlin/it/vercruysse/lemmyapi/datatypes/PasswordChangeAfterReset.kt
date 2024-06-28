package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class PasswordChangeAfterReset(
    val token: String,
    val password: String,
    val password_verify: String,
) : DatatypeRoot
