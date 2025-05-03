package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PostReport(
    val id: PostReportId,
    val creator_id: PersonId,
    val post_id: PostId,
    val original_post_name: String,
    val original_post_url: DbUrl? = null,
    val original_post_body: String? = null,
    val reason: String,
    val resolved: Boolean,
    val resolver_id: PersonId? = null,
    val published: String,
    val updated: String? = null,
    val violates_instance_rules: Boolean,
)
