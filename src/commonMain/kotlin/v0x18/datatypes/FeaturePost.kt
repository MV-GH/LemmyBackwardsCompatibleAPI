package v0x18.datatypes

import PostFeatureType
import kotlinx.serialization.Serializable

@Serializable
data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType /* "Local" | "Community" */,
    val auth: String,
)
