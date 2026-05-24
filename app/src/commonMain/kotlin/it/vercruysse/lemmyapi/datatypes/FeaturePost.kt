package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.PostFeatureType
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class FeaturePost(
    val post_id: PostId,
    val featured: Boolean,
    val feature_type: PostFeatureType /* "Local" | "Community" */,
) : DatatypeRoot
