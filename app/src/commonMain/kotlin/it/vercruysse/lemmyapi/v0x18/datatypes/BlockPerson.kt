package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class BlockPerson(
    val person_id: PersonId,
    val block: Boolean,
    val auth: String,
)
