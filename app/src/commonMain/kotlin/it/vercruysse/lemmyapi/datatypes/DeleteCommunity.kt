package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteCommunity(
    val community_id: CommunityId,
    val deleted: Boolean,
)
