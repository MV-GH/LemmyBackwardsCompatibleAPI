package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LoginToken(
    val user_id: LocalUserId,
    val published: String,
    val ip: String? = null,
    val user_agent: String? = null,
)
