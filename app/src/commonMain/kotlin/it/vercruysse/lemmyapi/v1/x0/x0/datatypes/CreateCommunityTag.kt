package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class CreateCommunityTag(
    val community_id: CommunityId,
    val display_name: String,
)
