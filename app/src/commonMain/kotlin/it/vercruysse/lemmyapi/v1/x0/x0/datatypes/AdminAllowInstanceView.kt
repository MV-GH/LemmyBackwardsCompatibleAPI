package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminAllowInstanceView(
    val admin_allow_instance: AdminAllowInstance,
    val instance: Instance,
    val admin: Person? = null,
)
