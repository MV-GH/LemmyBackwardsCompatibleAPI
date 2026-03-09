package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class GetPersonDetails(
    val person_id: PersonId? = null,
    val username: String? = null,
) : DatatypeRoot
