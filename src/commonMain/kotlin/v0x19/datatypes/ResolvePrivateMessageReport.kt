package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolvePrivateMessageReport(
    val report_id: PrivateMessageReportId,
    val resolved: Boolean,
)
