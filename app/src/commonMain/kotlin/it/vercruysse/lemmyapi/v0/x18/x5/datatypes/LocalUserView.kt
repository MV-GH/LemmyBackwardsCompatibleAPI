package it.vercruysse.lemmyapi.v0.x18.x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val counts: PersonAggregates,
)
