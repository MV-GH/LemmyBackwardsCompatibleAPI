package it.vercruysse.lemmyapi.enums

import kotlinx.serialization.Serializable

// TODO: mapped from previous version

@Serializable
enum class CommunityFollowerState {
    Accepted,
    Pending,
    ApprovalRequired,
    Denied
    ;

    companion object {
        fun from(d: SubscribedType): CommunityFollowerState? =
            when (d) {
                SubscribedType.Subscribed -> Accepted
                SubscribedType.NotSubscribed -> null
                SubscribedType.Pending -> Pending
            }
    }
}
