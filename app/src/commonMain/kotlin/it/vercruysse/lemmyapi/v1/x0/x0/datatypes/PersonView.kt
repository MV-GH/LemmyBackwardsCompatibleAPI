package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class PersonView(
    val person: Person,
    val is_admin: Boolean,
    val home_instance_actions: InstanceActions? = null,
    val local_instance_actions: InstanceActions? = null,
    val creator_banned: Boolean,
)
