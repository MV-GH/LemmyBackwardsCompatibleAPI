package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonView(
    val person: Person,
    val counts: PersonAggregates,
)
