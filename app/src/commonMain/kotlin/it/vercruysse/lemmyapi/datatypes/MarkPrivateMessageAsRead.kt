package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: removed

@CommonParcelize
@Serializable
data class MarkPrivateMessageAsRead(
    val private_message_id: PrivateMessageId,
    val read: Boolean,
) : DatatypeRoot
