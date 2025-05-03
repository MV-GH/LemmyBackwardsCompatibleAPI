package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class MyUserInfo(
    val local_user_view: LocalUserView,
    val follows: List<CommunityFollowerView>,
    val moderates: List<CommunityModeratorView>,
    val community_blocks: List<Community>,
    val instance_blocks: List<Instance>,
    val person_blocks: List<Person>,
    val keyword_blocks: List<String>,
    val discussion_languages: List<LanguageId>,
)
