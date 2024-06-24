package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    // Added in 0.19.4
    // TODO Possible add actual default instead?
    val local_user_vote_display_mode: LocalUserVoteDisplayMode? = null,
    val person: Person,
    val counts: PersonAggregates,
)
