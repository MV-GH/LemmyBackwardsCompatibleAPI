package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class MyUserInfo(
    val local_user_view: LocalUserView,
    val follows: List<CommunityFollowerView>,
    val moderates: List<CommunityModeratorView>,
    val community_blocks: List<CommunityBlockView>,
    val instance_blocks: List<InstanceBlockView>,
    val person_blocks: List<PersonBlockView>,
    val discussion_languages: List<LanguageId>,
)
