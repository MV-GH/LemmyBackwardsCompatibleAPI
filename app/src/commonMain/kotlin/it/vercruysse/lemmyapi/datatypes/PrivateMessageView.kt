package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import kotlinx.serialization.SerialName

@CommonParcelize
@Serializable
@SerialName("private_message")
data class PrivateMessageView(
    val private_message: PrivateMessage,
    val creator: Person,
    val recipient: Person,
) : DatatypeRoot, Identity, NotificationData {
    override val id: Long
        get() = private_message.id
}
