package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetCommunity(
    val id: CommunityId? = null,
    val name: String? = null,
)
