package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModRemovePostView(
    val mod_remove_post: ModRemovePost,
    val moderator: Person? = null,
    val post: Post,
    val community: Community,
) : DatatypeRoot
