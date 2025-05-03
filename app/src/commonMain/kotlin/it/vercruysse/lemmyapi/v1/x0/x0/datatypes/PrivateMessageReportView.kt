package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessageReportView(
    val private_message_report: PrivateMessageReport,
    val private_message: PrivateMessage,
    val creator: Person,
    val private_message_creator: Person,
    val resolver: Person? = null,
)
