package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class VoteView(
    val creator: Person,
    val score: Int,
)
