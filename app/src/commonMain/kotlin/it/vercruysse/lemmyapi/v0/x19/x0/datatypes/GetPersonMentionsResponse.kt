package it.vercruysse.lemmyapi.v0.x19.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPersonMentionsResponse(
    val mentions: List<PersonMentionView>,
)
