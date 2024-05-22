package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonView(
    val person: Person,
    val counts: PersonAggregates,
    val is_admin: Boolean,
)
