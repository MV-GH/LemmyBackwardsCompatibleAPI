package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgeCommunity(
    override val id: Long,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val when_: String,
) : DatatypeRoot, Identity
