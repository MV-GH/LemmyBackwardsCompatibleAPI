package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("person")
internal data class PersonView(
    val person: Person,
    val is_admin: Boolean,
    val person_actions: PersonActions? = null,
    val banned: Boolean,
    val ban_expires_at: String? = null,
) : SearchCombinedView
