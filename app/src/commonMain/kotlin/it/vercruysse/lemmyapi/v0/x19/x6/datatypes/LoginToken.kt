package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LoginToken(
    val user_id: LocalUserId,
    val published: String,
    val ip: String? = null,
    val user_agent: String? = null,
)
