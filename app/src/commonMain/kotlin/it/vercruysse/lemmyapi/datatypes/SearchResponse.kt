package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.SearchType
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: Changes

@CommonParcelize
@Serializable
data class SearchResponse(
    val type_: SearchType /* "All" | "Comments" | "Posts" | "Communities" | "Users" | "Url" */,
    val comments: List<CommentView>,
    val posts: List<PostView>,
    val communities: List<CommunityView>,
    val users: List<PersonView>,
) : DatatypeRoot
