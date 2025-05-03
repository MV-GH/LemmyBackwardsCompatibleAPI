package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessageReportResponse(
    val private_message_report_view: PrivateMessageReportView,
)
