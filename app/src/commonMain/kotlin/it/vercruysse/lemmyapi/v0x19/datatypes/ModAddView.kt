package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModAddView(
    val mod_add: ModAdd,
    val moderator: Person? = null,
    val modded_person: Person,
)
