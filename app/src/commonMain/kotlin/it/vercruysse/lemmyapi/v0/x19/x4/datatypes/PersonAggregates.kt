package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonAggregates(
    val person_id: PersonId,
    val post_count: Long,
    val comment_count: Long,
)
