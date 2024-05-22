package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPrivateMessageReportsResponse(
    val private_message_reports: List<PrivateMessageReportView>,
)
