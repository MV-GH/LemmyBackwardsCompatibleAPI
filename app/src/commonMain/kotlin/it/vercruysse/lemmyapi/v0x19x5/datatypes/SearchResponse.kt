package it.vercruysse.lemmyapi.v0x19x5.datatypes

import it.vercruysse.lemmyapi.dto.SearchType
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val type_: SearchType /* "All" | "Comments" | "Posts" | "Communities" | "Users" | "Url" */,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val communities: List<CommunityView>,
    val users: List<PersonView>,
)
