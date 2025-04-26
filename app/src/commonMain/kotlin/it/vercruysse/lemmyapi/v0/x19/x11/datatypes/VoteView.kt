package it.vercruysse.lemmyapi.v0.x19.x11.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class VoteView(
    val creator: Person,
    val creator_banned_from_community: Boolean,
    val score: Long,
)
