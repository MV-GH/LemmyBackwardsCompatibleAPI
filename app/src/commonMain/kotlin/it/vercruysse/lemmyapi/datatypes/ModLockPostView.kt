package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModLockPostView(
    val mod_lock_post: ModLockPost,
    val moderator: Person? = null,
    val post: Post,
    val community: Community,
) : DatatypeRoot
