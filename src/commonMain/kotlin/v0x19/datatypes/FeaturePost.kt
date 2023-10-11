package v0x19.datatypes

import dto.PostFeatureType
import kotlinx.serialization.Serializable

@Serializable
data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType /* "Local" | "Community" */,
)
