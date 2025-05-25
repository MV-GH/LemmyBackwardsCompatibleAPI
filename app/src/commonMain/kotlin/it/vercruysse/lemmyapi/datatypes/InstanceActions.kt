package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class InstanceActions(
    val person_id: PersonId,
    val instance_id: InstanceId,
    val blocked: String? = null,
    val received_ban: String? = null,
    val ban_expires: String? = null,
): DatatypeRoot
