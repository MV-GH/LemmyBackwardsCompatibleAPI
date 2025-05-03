package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class RegistrationApplication(
    val id: RegistrationApplicationId,
    val local_user_id: LocalUserId,
    val answer: String,
    val admin_id: PersonId? = null,
    val deny_reason: String? = null,
    val published: String,
)
