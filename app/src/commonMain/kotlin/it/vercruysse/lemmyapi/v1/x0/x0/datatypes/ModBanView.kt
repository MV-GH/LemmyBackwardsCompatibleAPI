package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModBanView(
    val mod_ban: ModBan,
    val moderator: Person? = null,
    val other_person: Person,
)
