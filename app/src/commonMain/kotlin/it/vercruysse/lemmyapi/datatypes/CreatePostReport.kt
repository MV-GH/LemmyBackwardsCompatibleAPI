package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreatePostReport(
    val post_id: PostId,
    val reason: String,
    /** Added in Lemmy 1.0.0 */
    val violates_instance_rules: Boolean? = null,
) : DatatypeRoot
