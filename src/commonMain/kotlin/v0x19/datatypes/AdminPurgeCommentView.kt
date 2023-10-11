package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgeCommentView(
    val admin_purge_comment: AdminPurgeComment,
    val admin: Person? = null,
    val post: Post,
)
