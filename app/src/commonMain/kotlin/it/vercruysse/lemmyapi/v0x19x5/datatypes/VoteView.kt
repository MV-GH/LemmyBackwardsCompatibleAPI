package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class VoteView(
    val creator: Person,
    val creator_banned_from_community: Boolean,
    val score: Long,
)
