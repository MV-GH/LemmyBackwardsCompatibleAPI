package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePersonView(
    val admin_purge_person: AdminPurgePerson,
    val admin: Person? = null,
)
