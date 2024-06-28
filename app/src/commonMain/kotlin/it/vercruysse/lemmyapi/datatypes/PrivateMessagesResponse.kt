package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessagesResponse(
    val private_messages: List<PrivateMessageView>,
) : DatatypeRoot
