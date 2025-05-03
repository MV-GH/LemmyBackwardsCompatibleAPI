package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Comment(
    val id: CommentId,
    val creator_id: PersonId,
    val post_id: PostId,
    val content: String,
    val removed: Boolean,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
    val ap_id: DbUrl,
    val local: Boolean,
    val path: String,
    val distinguished: Boolean,
    val language_id: LanguageId,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val child_count: Long,
    val report_count: Long,
    val unresolved_report_count: Long,
    val federation_pending: Boolean,
)
