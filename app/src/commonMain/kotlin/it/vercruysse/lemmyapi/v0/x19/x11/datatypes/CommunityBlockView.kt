package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityBlockView(
    val person: Person,
    val community: Community,
)
