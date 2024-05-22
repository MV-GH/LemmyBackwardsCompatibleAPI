package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModLockPostView(
    val mod_lock_post: ModLockPost,
    val moderator: Person? = null,
    val post: Post,
    val community: Community,
)
