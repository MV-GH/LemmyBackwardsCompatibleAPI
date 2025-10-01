package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Comment(
    override val id: CommentId,
    val creator_id: PersonId,
    val post_id: PostId,
    val content: String,
    val removed: Boolean,
    val published_at: String,
    val updated_at: String? = null,
    val deleted: Boolean,
    val ap_id: String,
    val local: Boolean,
    val path: String,
    val distinguished: Boolean,
    val language_id: LanguageId,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val child_count: Long,
    /** Added in Lemmy 1.0.0 */
    val report_count: Long,
    /** Added in Lemmy 1.0.0 */
    val unresolved_report_count: Long,
    /** Added in Lemmy 1.0.0 */
    val federation_pending: Boolean,
    /** Added in Lemmy 1.0.0 */
    val locked: Boolean,
) : DatatypeRoot, Identity
