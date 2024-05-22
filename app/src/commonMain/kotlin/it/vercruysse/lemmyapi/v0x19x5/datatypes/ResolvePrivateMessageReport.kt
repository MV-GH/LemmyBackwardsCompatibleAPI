package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ResolvePrivateMessageReport(
    val report_id: PrivateMessageReportId,
    val resolved: Boolean,
)
