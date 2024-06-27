package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetCommunity(
    val id: CommunityId? = null,
    val name: String? = null,
    val auth: String? = null,
)
