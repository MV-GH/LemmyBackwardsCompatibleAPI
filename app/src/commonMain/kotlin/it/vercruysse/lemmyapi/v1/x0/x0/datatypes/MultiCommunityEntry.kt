package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MultiCommunityEntry(
    val multi_community_id: MultiCommunityId,
    val community_id: CommunityId,
)
