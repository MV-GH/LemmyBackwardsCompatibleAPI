package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ChangePassword(
    val new_password: String,
    val new_password_verify: String,
    val old_password: String,
)
