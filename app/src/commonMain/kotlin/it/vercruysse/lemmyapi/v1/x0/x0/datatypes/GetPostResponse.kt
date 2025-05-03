package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPostResponse(
    val post_view: PostView,
    val community_view: CommunityView,
    val cross_posts: List<PostView>,
)
