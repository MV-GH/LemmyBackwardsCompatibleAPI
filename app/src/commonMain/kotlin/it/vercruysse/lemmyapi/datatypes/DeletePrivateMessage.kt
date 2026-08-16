package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class DeletePrivateMessage(
    val private_message_id: PrivateMessageId,
    val deleted: Boolean,
) : DatatypeRoot
