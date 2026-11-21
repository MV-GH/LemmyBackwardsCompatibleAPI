package it.vercruysse.lemmyapi.enums

import io.github.z4kn4fein.semver.Version
import it.vercruysse.lemmyapi.MINIMUM_API_VERSION
import it.vercruysse.lemmyapi.V1_0_0
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class NotificationDataType(override val minimumVersion: Version = MINIMUM_API_VERSION, override val maximumVersion: Version? = null) : VersionTracker {
    @SerialName("all")
    All,

    @SerialName("reply")
    Reply,

    @SerialName("mention")
    Mention,

    @SerialName("private_message")
    PrivateMessage,

    @SerialName("subscribed")
    Subscribed(V1_0_0),

    @SerialName("mod_action")
    ModAction(V1_0_0),
}
