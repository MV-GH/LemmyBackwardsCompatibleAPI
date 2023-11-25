package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetPersonDetailsResponse(
    val person_view: PersonView,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val moderates: List<CommunityModeratorView>,
)
