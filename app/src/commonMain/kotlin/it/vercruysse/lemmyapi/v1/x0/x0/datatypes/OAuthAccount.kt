package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class OAuthAccount(
    val local_user_id: LocalUserId,
    val oauth_provider_id: OAuthProviderId,
    val oauth_user_id: String,
    val published: String,
    val updated: String? = null,
)
