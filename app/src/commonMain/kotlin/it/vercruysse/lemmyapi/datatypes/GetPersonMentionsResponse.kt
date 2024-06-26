package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPersonMentionsResponse(
    val mentions: List<PersonMentionView>,
)