package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonAggregates(
    val id: Long,
    val person_id: PersonId,
    val post_count: Long,
    val post_score: Long,
    val comment_count: Long,
    val comment_score: Long,
)
