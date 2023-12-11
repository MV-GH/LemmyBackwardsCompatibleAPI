package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetPersonDetailsResponse(
    val person_view: PersonView,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val moderates: List<CommunityModeratorView>,
)
