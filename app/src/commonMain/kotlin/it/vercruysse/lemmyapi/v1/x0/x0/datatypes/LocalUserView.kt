package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalUserView(
    val local_user: LocalUser,
    val person: Person,
    val instance_actions: InstanceActions? = null,
)
