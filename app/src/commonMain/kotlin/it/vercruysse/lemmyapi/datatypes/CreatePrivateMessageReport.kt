package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
) : DatatypeRoot
