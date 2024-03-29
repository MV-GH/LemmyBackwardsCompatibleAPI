package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModLockPost(
    val id: Long,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val locked: Boolean,
    val when_: String,
)
