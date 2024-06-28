package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BlockPerson(
    val person_id: PersonId,
    val block: Boolean,
) : DatatypeRoot
