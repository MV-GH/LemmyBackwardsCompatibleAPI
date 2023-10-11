package v0x19.datatypes

import dto.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
data class CommunityView(
    val community: Community,
    val subscribed: SubscribedType /* "Subscribed" | "NotSubscribed" | "Pending" */,
    val blocked: Boolean,
    val counts: CommunityAggregates,
)
