package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModRemoveCommunityView(
    val mod_remove_community: ModRemoveCommunity,
    val moderator: Person? = null,
    val community: Community,
)
