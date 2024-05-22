package it.vercruysse.lemmyapi.v0x19x5.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
data class CommunityView(
    val community: Community,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val blocked: Boolean,
    val counts: CommunityAggregates,
    val banned_from_community: Boolean,
)
