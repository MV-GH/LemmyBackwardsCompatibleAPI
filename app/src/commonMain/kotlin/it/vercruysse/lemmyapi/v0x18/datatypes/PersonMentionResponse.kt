package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonMentionResponse(
    val person_mention_view: PersonMentionView,
)
