package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModAddCommunityView(
    val mod_add_community: ModAddCommunity,
    val moderator: Person? = null,
    val community: Community,
    val modded_person: Person,
)
