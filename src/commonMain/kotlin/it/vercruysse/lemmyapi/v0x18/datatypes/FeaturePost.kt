package it.vercruysse.lemmyapi.v0x18.datatypes

import it.vercruysse.lemmyapi.dto.PostFeatureType
import kotlinx.serialization.Serializable

@Serializable
internal data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType /* "Local" | "Community" */,
    val auth: String,
)
