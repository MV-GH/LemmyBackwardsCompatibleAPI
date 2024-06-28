package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class GetPersonMentionsResponse(
    val mentions: List<PersonMentionView>,
) : DatatypeRoot
