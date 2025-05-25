package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModBanView(
    val mod_ban: ModBan,
    val moderator: Person? = null,
    val other_person: Person,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = mod_ban.id
}
