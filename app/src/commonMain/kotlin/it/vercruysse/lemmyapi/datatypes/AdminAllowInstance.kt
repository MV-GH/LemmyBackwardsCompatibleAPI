package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AdminAllowInstance(
    val id: AdminAllowInstanceId,
    val instance_id: InstanceId,
    val admin_person_id: PersonId,
    val allowed: Boolean,
    val reason: String? = null,
    val published: String,
): DatatypeRoot
