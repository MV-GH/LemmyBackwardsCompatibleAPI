package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalUserInvite(
    val token: String,
    val max_uses: Long? = null,
    val uses_count: Long,
    val expires_at: String? = null,
    val published_at: String,
)
