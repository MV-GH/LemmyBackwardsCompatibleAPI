package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetCommunity(
    val id: CommunityId? = null,
    val name: String? = null,
    val auth: String? = null,
)
