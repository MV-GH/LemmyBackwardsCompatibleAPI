package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePerson(
    val id: Long,
    val admin_person_id: PersonId,
    val reason: String? = null,
    val when_: String,
)
