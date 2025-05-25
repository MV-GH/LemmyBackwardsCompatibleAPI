package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class PasswordChangeAfterReset(
    val token: SensitiveString,
    val password: SensitiveString,
    val password_verify: SensitiveString,
) : DatatypeRoot
