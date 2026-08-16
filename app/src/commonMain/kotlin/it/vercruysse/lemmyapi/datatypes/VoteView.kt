package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class VoteView(
    val creator: Person,
    val creator_banned: Boolean,
    val creator_banned_from_community: Boolean,
    val vote: VoteAction,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = creator.id
}
