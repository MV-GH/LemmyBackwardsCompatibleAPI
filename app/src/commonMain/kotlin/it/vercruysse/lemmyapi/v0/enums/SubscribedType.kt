package it.vercruysse.lemmyapi.v0.enums

import kotlinx.serialization.Serializable

@Serializable
internal enum class SubscribedType {
    Subscribed,
    NotSubscribed,
    Pending,
}
