package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModBanView(
    val mod_ban: ModBan,
    val moderator: Person? = null,
    val banned_person: Person,
)
