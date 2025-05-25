package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class GetPostResponse(
    val post_view: PostView,
    val community_view: CommunityView,
    /** Removed in Lemmy 1.0.0 */
    val moderators: List<CommunityModeratorView> = emptyList(),
    val cross_posts: List<PostView>,
) : DatatypeRoot
