package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class MyUserInfo(
    val local_user_view: LocalUserView,
    val follows: List<CommunityFollowerView>,
    val moderates: List<CommunityModeratorView>,
    val community_blocks: List<Community>,
    val instance_blocks: List<Instance>,
    val person_blocks: List<Person>,
    /** Added in Lemmy 1.0.0 */
    val keyword_blocks: List<String> = emptyList(),
    val discussion_languages: List<LanguageId>,
) : DatatypeRoot
