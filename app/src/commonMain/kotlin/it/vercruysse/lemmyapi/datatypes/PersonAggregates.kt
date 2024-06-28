package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PersonAggregates(
    val person_id: PersonId,
    val post_count: Long,
    val comment_count: Long,
) : DatatypeRoot
