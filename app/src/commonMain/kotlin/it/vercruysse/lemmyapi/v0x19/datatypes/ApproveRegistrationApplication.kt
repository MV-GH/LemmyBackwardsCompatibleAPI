package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ApproveRegistrationApplication(
    val id: Int,
    val approve: Boolean,
    val deny_reason: String? = null,
)
