package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ApproveRegistrationApplication(
    val id: Long,
    val approve: Boolean,
    val deny_reason: String? = null,
    val auth: String,
)
