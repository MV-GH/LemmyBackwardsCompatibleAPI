package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgePersonView(
    val admin_purge_person: AdminPurgePerson,
    val admin: Person? = null,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = admin_purge_person.id
}
