package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PostReport(
    override val id: PostReportId,
    val creator_id: PersonId,
    val post_id: PostId,
    val original_post_name: String,
    val original_post_url: String? = null,
    val original_post_body: String? = null,
    val reason: String,
    val resolved: Boolean,
    val resolver_id: PersonId? = null,
    val published_at: String,
    val updated_at: String? = null,
    /** Added in Lemmy 1.0.0 */
    val violates_instance_rules: Boolean,
) : DatatypeRoot, Identity
