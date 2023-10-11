package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class BlockInstance(
    val instance_id: InstanceId,
    val block: Boolean,
)
