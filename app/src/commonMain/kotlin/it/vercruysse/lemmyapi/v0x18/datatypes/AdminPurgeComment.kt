package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminPurgeComment(
    val id: Long,
    val admin_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val when_: String,
)
