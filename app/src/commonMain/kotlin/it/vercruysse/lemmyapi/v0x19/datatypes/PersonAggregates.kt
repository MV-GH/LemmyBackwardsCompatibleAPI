package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonAggregates(
    val person_id: PersonId,
    val post_count: Int,
    val comment_count: Int,
)
