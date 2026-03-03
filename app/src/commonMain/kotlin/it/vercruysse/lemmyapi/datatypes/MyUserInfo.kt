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
    /** Added in Lemmy 1.0.0 */
    val multi_community_follows: List<MultiCommunityView>,
    val community_blocks: List<Community>,
    val instance_communities_blocks: List<Instance>,
    val instance_persons_blocks: List<Instance>,
    val person_blocks: List<Person>,
    /** Added in Lemmy 1.0.0 */
    val keyword_blocks: List<String> = emptyList(),
    val discussion_languages: List<LanguageId>,
) : DatatypeRoot
