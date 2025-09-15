package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val banned: Boolean,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = local_user.id
}
