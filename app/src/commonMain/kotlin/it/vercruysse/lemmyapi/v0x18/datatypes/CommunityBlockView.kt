package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityBlockView(
    val person: Person,
    val community: Community,
)
