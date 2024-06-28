package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PersonMentionResponse(
    val person_mention_view: PersonMentionView,
) : DatatypeRoot
