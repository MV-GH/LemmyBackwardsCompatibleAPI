package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    val local_user_vote_display_mode: LocalUserVoteDisplayMode? = null, // Added in 0.19.4
    val person: Person,
    val counts: PersonAggregates,
)
