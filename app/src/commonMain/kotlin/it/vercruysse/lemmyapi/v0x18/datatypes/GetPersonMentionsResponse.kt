package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPersonMentionsResponse(
    val mentions: List<PersonMentionView>,
)
