package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ChangePassword(
    val new_password: SensitiveString,
    val new_password_verify: SensitiveString,
    val old_password: SensitiveString,
    val stay_logged_in: Boolean? = null,
) : DatatypeRoot
