package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPostResponse(
    val post_view: PostView,
    val community_view: CommunityView,
    val moderators: List<CommunityModeratorView>,
    val cross_posts: List<PostView>,
)
