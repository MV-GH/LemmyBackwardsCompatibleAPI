package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ListPrivateMessageReportsResponse(
    val private_message_reports: List<PrivateMessageReportView>,
)
