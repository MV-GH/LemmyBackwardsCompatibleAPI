package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LoginToken(
    val user_id: LocalUserId,
    val published: String,
    val ip: String? = null,
    val user_agent: String? = null,
)
