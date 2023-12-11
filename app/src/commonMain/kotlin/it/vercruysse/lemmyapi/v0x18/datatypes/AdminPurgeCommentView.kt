package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeCommentView(
    val admin_purge_comment: AdminPurgeComment,
    val admin: Person? = null,
    val post: Post,
)
