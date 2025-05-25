package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModLockPostView(
    val mod_lock_post: ModLockPost,
    val moderator: Person? = null,
    /** Added in Lemmy 1.0.0 */
    val other_person: Person? = null,
    val post: Post,
    val community: Community,
) : DatatypeRoot
