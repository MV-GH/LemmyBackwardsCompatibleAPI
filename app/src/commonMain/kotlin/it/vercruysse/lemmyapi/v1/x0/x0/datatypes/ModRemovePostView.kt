package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemovePostView(
    val mod_remove_post: ModRemovePost,
    val moderator: Person? = null,
    val other_person: Person,
    val post: Post,
    val community: Community,
)
