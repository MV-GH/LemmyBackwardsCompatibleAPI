package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminAllowInstance(
    val id: AdminAllowInstanceId,
    val instance_id: InstanceId,
    val admin_person_id: PersonId,
    val allowed: Boolean,
    val reason: String? = null,
    val published: String,
)
