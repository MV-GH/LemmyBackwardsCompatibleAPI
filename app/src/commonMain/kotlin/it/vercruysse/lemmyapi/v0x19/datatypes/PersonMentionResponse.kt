package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonMentionResponse(
    val person_mention_view: PersonMentionView,
)
