package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class AddAdmin(
    val person_id: PersonId,
    val added: Boolean,
) : DatatypeRoot
