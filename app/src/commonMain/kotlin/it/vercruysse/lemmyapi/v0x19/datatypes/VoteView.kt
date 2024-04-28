package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class VoteView(
    val creator: Person,
    val creator_banned_from_community: Boolean = false, // Added 0.19.4
    val score: Long,
)
