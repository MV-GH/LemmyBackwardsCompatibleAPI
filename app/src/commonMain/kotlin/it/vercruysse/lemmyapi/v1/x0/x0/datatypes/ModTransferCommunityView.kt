package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModTransferCommunityView(
    val mod_transfer_community: ModTransferCommunity,
    val moderator: Person? = null,
    val community: Community,
    val other_person: Person,
)
