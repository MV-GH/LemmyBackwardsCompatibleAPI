package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class GetCommentsResponse(
    val comments: List<CommentView>,
    /** Added in Lemmy 1.0.0 */
    val next_page: PaginationCursor? = null,
    /** Added in Lemmy 1.0.0 */
    val prev_page: PaginationCursor? = null,
) : DatatypeRoot
