package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResponse(
    val resolve: ResolveObjectView? = null,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val communities: List<CommunityView>,
    val persons: List<PersonView>,
    val multi_communities: List<MultiCommunityView>,
    val prev_page: PaginationCursor? = null,
    val next_page: PaginationCursor? = null,
)
