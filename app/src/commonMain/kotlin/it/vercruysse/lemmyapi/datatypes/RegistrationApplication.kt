package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class RegistrationApplication(
    val id: RegistrationApplicationId,
    val local_user_id: LocalUserId,
    val answer: String,
    val admin_id: PersonId? = null,
    val deny_reason: String? = null,
    val published_at: String,
    val updated_at: String? = null,
) : DatatypeRoot
