package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import kotlinx.serialization.SerialName

@CommonParcelize
@Serializable
@SerialName("private_message")
data class PrivateMessageReportView(
    val private_message_report: PrivateMessageReport,
    val private_message: PrivateMessage,
    val private_message_creator: Person,
    val creator: Person,
    val resolver: Person? = null,
    val creator_is_admin: Boolean,
    val creator_banned: Boolean,
    val creator_ban_expires_at: String? = null,
) : DatatypeRoot, Identity, ReportCombinedView {
    override val id: Long
        get() = private_message_report.id
}
