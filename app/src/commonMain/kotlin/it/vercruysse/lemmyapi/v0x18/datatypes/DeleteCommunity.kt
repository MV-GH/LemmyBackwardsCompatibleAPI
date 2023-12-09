package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class DeleteCommunity(
    val community_id: CommunityId,
    val deleted: Boolean,
    val auth: String,
)
