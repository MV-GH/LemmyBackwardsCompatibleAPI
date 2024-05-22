package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockPerson(
    val person_id: PersonId,
    val block: Boolean,
)
