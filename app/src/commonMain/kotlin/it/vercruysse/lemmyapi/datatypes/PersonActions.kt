package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PersonActions(
    val target_id: PersonId,
    val person_id: PersonId,
    val blocked: String? = null,
): DatatypeRoot
