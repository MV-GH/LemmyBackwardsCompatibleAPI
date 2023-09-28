package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class ModlogListParams(
    val community_id: CommunityId? = null,
    val mod_person_id: PersonId? = null,
    val other_person_id: PersonId? = null,
    val page: Int? = null,
    val limit: Int? = null,
    val hide_modlog_names: Boolean,
)
