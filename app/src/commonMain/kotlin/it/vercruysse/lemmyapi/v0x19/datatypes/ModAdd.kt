package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModAdd(
    val id: Long,
    val mod_person_id: PersonId,
    val other_person_id: PersonId,
    val removed: Boolean,
    val when_: String,
)
