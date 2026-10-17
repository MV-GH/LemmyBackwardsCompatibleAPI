package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MyUserInfo(
    val local_user_view: LocalUserView,
    val follows: List<CommunityFollowerView>,
    val moderates: List<CommunityModeratorView>,
    val multi_community_follows: List<MultiCommunityView>,
    val community_blocks: List<Community>,
    val instance_communities_blocks: List<Instance>,
    val instance_persons_blocks: List<Instance>,
    val person_blocks: List<Person>,
    val keyword_blocks: List<String>,
    val discussion_languages: List<LanguageId>,
)
