package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ApproveRegistrationApplication(
    val id: Long,
    val approve: Boolean,
    val deny_reason: String? = null,
)
