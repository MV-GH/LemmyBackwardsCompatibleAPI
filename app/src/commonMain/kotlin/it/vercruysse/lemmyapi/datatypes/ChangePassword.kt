package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ChangePassword(
    val new_password: SensitiveString,
    val new_password_verify: SensitiveString,
    val old_password: SensitiveString,
) : DatatypeRoot
