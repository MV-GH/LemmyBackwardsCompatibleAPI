package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class PrivateMessageReportResponse(
    val private_message_report_view: PrivateMessageReportView,
) : DatatypeRoot
