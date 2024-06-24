package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PrivateMessageReportResponse(
    val private_message_report_view: PrivateMessageReportView,
)
