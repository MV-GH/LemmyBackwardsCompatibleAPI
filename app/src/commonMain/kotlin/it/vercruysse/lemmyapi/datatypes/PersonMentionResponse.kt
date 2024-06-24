package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class PersonMentionResponse(
    val person_mention_view: PersonMentionView,
)
