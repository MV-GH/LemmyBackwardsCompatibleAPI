package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class EditPrivateMessage(
    val private_message_id: PrivateMessageId,
    val content: String,
) : DatatypeRoot
