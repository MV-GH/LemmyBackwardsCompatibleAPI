package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalUserInvite(
    val id: InvitationId,
    val token: String,
    val local_user_id: LocalUserId,
    val max_uses: Long? = null,
    val uses_count: Long,
    val expires_at: String? = null,
    val published_at: String,
)
