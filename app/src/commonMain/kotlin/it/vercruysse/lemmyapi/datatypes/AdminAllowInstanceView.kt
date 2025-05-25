package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AdminAllowInstanceView(
    val admin_allow_instance: AdminAllowInstance,
    val instance: Instance,
    val admin: Person? = null,
): DatatypeRoot
