package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeCommunity(
    val id: Long,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val when_: String,
)
