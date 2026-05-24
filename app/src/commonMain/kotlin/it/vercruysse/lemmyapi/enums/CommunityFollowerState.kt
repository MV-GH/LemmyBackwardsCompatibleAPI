package it.vercruysse.lemmyapi.enums

import it.vercruysse.lemmyapi.v0.enums.SubscribedType
import kotlinx.serialization.Serializable

@Serializable
enum class CommunityFollowerState {
    Accepted,
    Pending,
    ApprovalRequired,
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
