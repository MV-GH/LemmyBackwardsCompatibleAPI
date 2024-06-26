package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ChangePassword(
    val new_password: String,
    val new_password_verify: String,
    val old_password: String,
) : DatatypeRoot
