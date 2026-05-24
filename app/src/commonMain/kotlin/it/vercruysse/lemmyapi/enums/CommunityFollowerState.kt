package it.vercruysse.lemmyapi.enums

import it.vercruysse.lemmyapi.v0.enums.SubscribedType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CommunityFollowerState {
    @SerialName("accepted")
    Accepted,

    @SerialName("pending")
    Pending,

    @SerialName("approval_required")
    ApprovalRequired,

    @SerialName("denied")
    Denied,
    ;

    companion object {
        internal fun from(d: SubscribedType): CommunityFollowerState? =
            when (d) {
                SubscribedType.Subscribed -> Accepted
                SubscribedType.NotSubscribed -> null
                SubscribedType.Pending -> Pending
            }
    }
}
