package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteCommunity(
    val community_id: CommunityId,
    val deleted: Boolean,
)
