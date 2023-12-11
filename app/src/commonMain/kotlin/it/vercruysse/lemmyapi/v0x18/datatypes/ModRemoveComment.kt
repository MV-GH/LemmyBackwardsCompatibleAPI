package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class ModRemoveComment(
    val id: Int,
    val mod_person_id: PersonId,
    val comment_id: CommentId,
    val reason: String? = null,
    val removed: Boolean,
    val when_: String,
)
