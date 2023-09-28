package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModAddView(
    val mod_add: ModAdd,
    val moderator: Person? = null,
    val modded_person: Person,
)
