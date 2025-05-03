package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemovePost(
    val id: ModRemovePostId,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val removed: Boolean,
    val published: String,
)
