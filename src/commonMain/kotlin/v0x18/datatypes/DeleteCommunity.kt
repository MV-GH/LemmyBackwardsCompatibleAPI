package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class DeleteCommunity(
    val community_id: CommunityId,
    val deleted: Boolean,
    val auth: String,
)
