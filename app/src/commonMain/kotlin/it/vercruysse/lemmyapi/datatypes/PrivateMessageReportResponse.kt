package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PrivateMessageReportResponse(
    val private_message_report_view: PrivateMessageReportView,
) : DatatypeRoot
