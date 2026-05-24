package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize


@CommonParcelize
@Serializable
data class SearchResponse(
    val resolve: ResolveObjectView? = null,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val communities: List<CommunityView>,
    val persons: List<PersonView>,
    val multi_communities: List<MultiCommunityView>,
    /** Added in 1.0.0 */
    val next_page: PaginationCursor? = null,
    /** Added in 1.0.0 */
    val prev_page: PaginationCursor? = null,
) : DatatypeRoot
