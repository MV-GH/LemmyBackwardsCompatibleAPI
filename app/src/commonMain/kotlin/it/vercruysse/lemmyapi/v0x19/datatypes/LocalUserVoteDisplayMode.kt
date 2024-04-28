package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

// Added in 0.19.4
@Serializable
data class LocalUserVoteDisplayMode(
    val local_user_id: LocalUserId,
    val score: Boolean,
    val upvotes: Boolean,
    val downvotes: Boolean,
    val upvote_percentage: Boolean,
)
