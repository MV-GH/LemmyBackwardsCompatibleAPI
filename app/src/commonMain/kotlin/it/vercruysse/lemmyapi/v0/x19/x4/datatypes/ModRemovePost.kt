package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemovePost(
    val id: Long,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val removed: Boolean,
    val when_: String,
)
