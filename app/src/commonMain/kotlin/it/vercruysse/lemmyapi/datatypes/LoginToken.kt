package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LoginToken(
    val user_id: LocalUserId,
    val published_at: String,
    val ip: String? = null,
    val user_agent: String? = null,
) : DatatypeRoot
