package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    val local_user_vote_display_mode: LocalUserVoteDisplayMode,
    val person: Person,
    val counts: PersonAggregates,
)
