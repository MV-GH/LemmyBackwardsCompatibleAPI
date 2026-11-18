package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LocalUserInvite(
    val token: String,
    val max_uses: Long? = null,
    val uses_count: Long,
    val expires_at: String? = null,
    val published_at: String,
) : DatatypeRoot
