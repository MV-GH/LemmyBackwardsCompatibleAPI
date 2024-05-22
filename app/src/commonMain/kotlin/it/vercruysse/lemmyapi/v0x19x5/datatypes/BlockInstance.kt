package it.vercruysse.lemmyapi.v0x19x5.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockInstance(
    val instance_id: InstanceId,
    val block: Boolean,
)
