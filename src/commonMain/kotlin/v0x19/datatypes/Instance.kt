package v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class Instance(
    val id: InstanceId,
    val domain: String,
    val published: String,
    val updated: String? = null,
    val software: String? = null,
    val version: String? = null,
)
