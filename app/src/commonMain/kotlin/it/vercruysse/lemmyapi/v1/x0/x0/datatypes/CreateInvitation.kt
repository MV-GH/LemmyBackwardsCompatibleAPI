package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateInvitation(
    val max_uses: Long? = null,
    val expires_at: String? = null,
)
