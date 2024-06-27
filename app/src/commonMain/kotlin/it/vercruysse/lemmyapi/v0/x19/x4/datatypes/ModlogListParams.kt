package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModlogListParams(
    val community_id: CommunityId? = null,
    val mod_person_id: PersonId? = null,
    val other_person_id: PersonId? = null,
    val post_id: PostId? = null,
    val comment_id: CommentId? = null,
    val page: Long? = null,
    val limit: Long? = null,
    val hide_modlog_names: Boolean,
)
