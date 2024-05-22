package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModBan(
    val id: Long,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val reason: String? = null,
    val banned: Boolean,
    val expires: String? = null,
    val when_: String,
)
