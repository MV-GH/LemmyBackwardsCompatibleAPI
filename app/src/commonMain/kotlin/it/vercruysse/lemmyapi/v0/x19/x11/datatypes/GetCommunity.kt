package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetCommunity(
    val id: CommunityId? = null,
    val name: String? = null,
)
