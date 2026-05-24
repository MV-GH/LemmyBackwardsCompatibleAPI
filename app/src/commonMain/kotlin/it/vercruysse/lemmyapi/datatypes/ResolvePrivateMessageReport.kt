package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class ResolvePrivateMessageReport(
    val report_id: PrivateMessageReportId,
    val resolved: Boolean,
) : DatatypeRoot
