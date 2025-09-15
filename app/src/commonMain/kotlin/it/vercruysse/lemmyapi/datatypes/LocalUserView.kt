package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: changes

@CommonParcelize
@Serializable
data class LocalUserView(
    val local_user: LocalUser,
    // Added in 0.19.4
    // TODO Possible add actual default instead?
    // TODO: removed?
    // TODO seems to be moved into local_user
    val local_user_vote_display_mode: LocalUserVoteDisplayMode? = null,
    val person: Person,
    /** Added in 1.0.0 */
    val banned: Boolean,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = local_user.id
}
