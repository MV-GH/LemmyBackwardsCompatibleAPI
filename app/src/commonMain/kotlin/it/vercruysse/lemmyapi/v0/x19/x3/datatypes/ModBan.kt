package it.vercruysse.lemmyapi.v0.x19.x3.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModBan(
    val id: Long,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val reason: String? = null,
    val banned: Boolean,
    val expires: String? = null,
    val when_: String,
)
