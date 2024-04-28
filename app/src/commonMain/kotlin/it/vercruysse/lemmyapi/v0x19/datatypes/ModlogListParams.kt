package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModlogListParams(
    val community_id: CommunityId? = null,
    val mod_person_id: PersonId? = null,
    val other_person_id: PersonId? = null,
    val post_id: PostId? = null, // Added in 0.19.4
    val comment_id: CommentId? = null, // Added in 0.19.4
    val page: Long? = null,
    val limit: Long? = null,
    val hide_modlog_names: Boolean,
)
