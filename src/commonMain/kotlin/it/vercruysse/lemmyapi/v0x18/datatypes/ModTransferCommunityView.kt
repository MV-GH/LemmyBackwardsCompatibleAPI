package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModTransferCommunityView(
    val mod_transfer_community: ModTransferCommunity,
    val moderator: Person? = null,
    val community: Community,
    val modded_person: Person,
)
