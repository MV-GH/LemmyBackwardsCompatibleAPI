package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageReportView(
    val private_message_report: PrivateMessageReport,
    val private_message: PrivateMessage,
    val private_message_creator: Person,
    val creator: Person,
    val resolver: Person? = null,
)
