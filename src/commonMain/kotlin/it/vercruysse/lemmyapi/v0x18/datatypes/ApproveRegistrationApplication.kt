package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ApproveRegistrationApplication(
    val id: Int,
    val approve: Boolean,
    val deny_reason: String? = null,
    val auth: String,
)
