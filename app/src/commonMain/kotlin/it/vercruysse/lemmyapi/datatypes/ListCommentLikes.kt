package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class ListCommentLikes(
    val comment_id: CommentId,
    /** Removed in 1.0.0 */
    val page: Long? = null,
    /** Added in 1.0.0 */
    val page_cursor: PaginationCursor? = null,
    /** Added in 1.0.0 */
    val page_back: Boolean? = null,
    val limit: Long? = null,
) : DatatypeRoot
