package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePersonView(
    val admin_purge_person: AdminPurgePerson,
    val admin: Person? = null,
)
