package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModLockPostView(
    val mod_lock_post: ModLockPost,
    val moderator: Person? = null,
    val other_person: Person,
    val post: Post,
    val community: Community,
)
