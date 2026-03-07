package it.vercruysse.lemmyapi.v0.x19.x3.datatypes

import it.vercruysse.lemmyapi.v0.enums.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityView(
    val community: Community,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val blocked: Boolean,
    val counts: CommunityAggregates,
)
