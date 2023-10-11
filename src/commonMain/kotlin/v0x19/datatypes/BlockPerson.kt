package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockPerson(
    val person_id: PersonId,
    val block: Boolean,
)
