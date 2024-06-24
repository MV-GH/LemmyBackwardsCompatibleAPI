package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModBanView(
    val mod_ban: ModBan,
    val moderator: Person? = null,
    val banned_person: Person,
)
