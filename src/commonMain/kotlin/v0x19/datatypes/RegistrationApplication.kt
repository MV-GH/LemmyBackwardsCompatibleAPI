package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationApplication(
    val id: Int,
    val local_user_id: LocalUserId,
    val answer: String,
    val admin_id: PersonId? = null,
    val deny_reason: String? = null,
    val published: String,
)
