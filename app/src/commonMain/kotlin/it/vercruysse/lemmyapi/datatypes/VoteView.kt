package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class VoteView(
    val creator: Person,
    val creator_banned_from_community: Boolean,
    val score: Long,
) : DatatypeRoot
