package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetPersonDetails(
    val person_id: PersonId? = null,
    val username: String? = null,
) : DatatypeRoot
