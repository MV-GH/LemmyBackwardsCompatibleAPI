package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: added item_id

@CommonParcelize
@Serializable
data class VoteView(
    val creator: Person,
    val creator_banned_from_community: Boolean,
    val score: Long,
) : DatatypeRoot, Identity {
    override val id: Long
        get() = creator.id
}
