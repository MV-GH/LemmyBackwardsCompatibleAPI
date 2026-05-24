package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ApproveRegistrationApplication(
    val id: RegistrationApplicationId,
    val approve: Boolean,
    val deny_reason: String? = null,
) : DatatypeRoot
