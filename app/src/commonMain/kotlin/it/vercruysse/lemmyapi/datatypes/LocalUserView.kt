package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val banned: Boolean,
    val ban_expires_at: String? = null,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = local_user.id
}
