package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@Serializable
data class BlockInstance(
    val instance_id: InstanceId,
    val block: Boolean,
) : DatatypeRoot
