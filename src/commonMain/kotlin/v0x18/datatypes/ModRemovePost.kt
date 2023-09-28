package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModRemovePost(
    val id: Int,
    val mod_person_id: PersonId,
    val post_id: PostId,
    val reason: String? = null,
    val removed: Boolean,
    val when_: String,
)
