package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageResponse(
    val private_message_view: PrivateMessageView,
) : DatatypeRoot
