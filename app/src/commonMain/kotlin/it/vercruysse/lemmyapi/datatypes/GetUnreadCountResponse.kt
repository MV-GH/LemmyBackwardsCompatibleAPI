package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetUnreadCountResponse(
    val replies: Long,
    val mentions: Long,
    val private_messages: Long,
) : DatatypeRoot
