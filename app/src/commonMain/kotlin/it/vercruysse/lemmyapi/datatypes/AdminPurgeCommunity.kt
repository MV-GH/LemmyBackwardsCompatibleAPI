package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgeCommunity(
    val id: Long,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val when_: String,
) : DatatypeRoot
