package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModLockPost(
    val id: ModLockPostId,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val locked: Boolean,
    val published: String,
)
