package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PersonView(
    val person: Person,
    val counts: PersonAggregates,
    val is_admin: Boolean,
) : DatatypeRoot
