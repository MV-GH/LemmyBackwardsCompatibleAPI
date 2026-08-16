package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class VoteView(
    val creator: Person,
    val creator_banned: Boolean,
    val creator_banned_from_community: Boolean,
    val is_upvote: Boolean,
)
