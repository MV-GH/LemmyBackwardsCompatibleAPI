package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class PurgePerson(
    val person_id: PersonId,
    val reason: String? = null,
) : DatatypeRoot
