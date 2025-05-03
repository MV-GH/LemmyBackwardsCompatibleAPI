package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeComment(
    val id: AdminPurgeCommentId,
    val admin_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val published: String,
)
