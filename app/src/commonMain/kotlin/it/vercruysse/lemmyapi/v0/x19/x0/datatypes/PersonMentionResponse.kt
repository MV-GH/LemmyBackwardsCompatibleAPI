package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonMentionResponse(
    val person_mention_view: PersonMentionView,
)
