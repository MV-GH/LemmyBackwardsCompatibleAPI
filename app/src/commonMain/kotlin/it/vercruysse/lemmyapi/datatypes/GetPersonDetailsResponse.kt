package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO research, comments posts

@CommonParcelize
@Serializable
data class GetPersonDetailsResponse(
    val person_view: PersonView,
    val site: Site? = null,
    // TODO: removed
    val comments: List<CommentView>,
    // TODO: removed
    val posts: List<PostView>,
    val moderates: List<CommunityModeratorView>,
    val multi_communities_created: List<MultiCommunityView>,
) : DatatypeRoot
