package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class AdminPurgeComment(
    val id: Long,
    val admin_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val when_: String,
)
