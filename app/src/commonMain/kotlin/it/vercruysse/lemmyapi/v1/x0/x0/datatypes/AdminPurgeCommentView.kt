package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeCommentView(
    val admin_purge_comment: AdminPurgeComment,
    val admin: Person? = null,
    val post: Post,
)
