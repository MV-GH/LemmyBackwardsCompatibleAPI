package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreatePrivateMessageReport(
    val private_message_id: PrivateMessageId,
    val reason: String,
) : DatatypeRoot
