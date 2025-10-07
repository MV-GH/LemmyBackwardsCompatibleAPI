package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class AdminBanView(
    val admin_ban: AdminBan,
    val moderator: Person? = null,
    val other_person: Person,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = admin_ban.id
}
