package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class ListPrivateMessageReportsResponse(
    val private_message_reports: List<PrivateMessageReportView>,
) : DatatypeRoot
