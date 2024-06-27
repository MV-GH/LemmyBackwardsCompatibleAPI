package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockPerson(
    val person_id: PersonId,
    val block: Boolean,
)
