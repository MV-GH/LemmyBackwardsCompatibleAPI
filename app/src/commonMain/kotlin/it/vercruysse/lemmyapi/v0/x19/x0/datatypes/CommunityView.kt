package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import it.vercruysse.lemmyapi.dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityView(
    val community: Community,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val blocked: Boolean,
    val counts: CommunityAggregates,
)
