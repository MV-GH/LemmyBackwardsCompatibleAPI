package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessageReportResponse(
    val private_message_report_view: PrivateMessageReportView,
)
