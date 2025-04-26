package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ListPrivateMessageReportsResponse(
    val private_message_reports: List<PrivateMessageReportView>,
)
