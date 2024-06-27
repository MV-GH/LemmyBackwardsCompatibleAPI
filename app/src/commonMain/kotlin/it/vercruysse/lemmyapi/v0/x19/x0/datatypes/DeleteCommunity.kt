package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteCommunity(
    val community_id: CommunityId,
    val deleted: Boolean,
)
