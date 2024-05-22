package it.vercruysse.lemmyapi.v0x19x5.datatypes

import it.vercruysse.lemmyapi.dto.PostFeatureType
import kotlinx.serialization.Serializable

@Serializable
data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType /* "Local" | "Community" */,
)
