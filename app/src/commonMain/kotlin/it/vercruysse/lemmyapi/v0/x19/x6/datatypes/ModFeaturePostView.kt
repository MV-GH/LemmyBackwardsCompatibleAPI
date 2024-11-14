package it.vercruysse.lemmyapi.v0.x19.x6.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModFeaturePostView(
    val mod_feature_post: ModFeaturePost,
    val moderator: Person? = null,
    val post: Post,
    val community: Community,
)
