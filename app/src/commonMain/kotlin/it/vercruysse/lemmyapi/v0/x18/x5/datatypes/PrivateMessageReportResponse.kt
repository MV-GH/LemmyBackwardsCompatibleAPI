package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PrivateMessageReportResponse(
    val private_message_report_view: PrivateMessageReportView,
)
