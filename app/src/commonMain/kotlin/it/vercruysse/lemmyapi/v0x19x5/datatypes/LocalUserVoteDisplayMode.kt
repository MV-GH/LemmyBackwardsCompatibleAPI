package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class LocalUserVoteDisplayMode(
    val local_user_id: LocalUserId,
    val score: Boolean,
    val upvotes: Boolean,
    val downvotes: Boolean,
    val upvote_percentage: Boolean,
)
