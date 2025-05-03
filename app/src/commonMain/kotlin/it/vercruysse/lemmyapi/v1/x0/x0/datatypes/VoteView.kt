package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class VoteView(
    val creator: Person,
    val item_id: Long,
    val creator_banned_from_community: Boolean,
    val score: Long,
)
