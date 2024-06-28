package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ModFeaturePostView(
    val mod_feature_post: ModFeaturePost,
    val moderator: Person? = null,
    val post: Post,
    val community: Community,
) : DatatypeRoot
