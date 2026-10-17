package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class UserBlockInstancePersonsParams(
    val instance_id: InstanceId,
    val block: Boolean,
) : DatatypeRoot
