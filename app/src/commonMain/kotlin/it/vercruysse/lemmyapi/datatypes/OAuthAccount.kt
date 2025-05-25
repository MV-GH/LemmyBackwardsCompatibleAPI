package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class OAuthAccount(
    val local_user_id: LocalUserId,
    val oauth_provider_id: OAuthProviderId,
    val oauth_user_id: String,
    val published: String,
    val updated: String? = null,
): DatatypeRoot
