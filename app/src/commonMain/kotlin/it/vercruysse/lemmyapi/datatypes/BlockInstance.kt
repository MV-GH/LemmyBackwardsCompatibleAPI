package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

// TODO: renamed to UserBlockInstanceParams

@CommonParcelize
@Serializable
data class BlockInstance(
    val instance_id: InstanceId,
    val block: Boolean,
) : DatatypeRoot
