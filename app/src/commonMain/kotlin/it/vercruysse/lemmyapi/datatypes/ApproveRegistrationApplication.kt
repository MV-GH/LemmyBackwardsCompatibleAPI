package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ApproveRegistrationApplication(
    val id: Long,
    val approve: Boolean,
    val deny_reason: String? = null,
) : DatatypeRoot
