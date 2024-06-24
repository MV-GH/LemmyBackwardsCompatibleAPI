package it.vercruysse.lemmyapi.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponse(
    val post_view: PostView,
    val community_view: CommunityView,
    val moderators: List<CommunityModeratorView>,
    val cross_posts: List<PostView>,
)
