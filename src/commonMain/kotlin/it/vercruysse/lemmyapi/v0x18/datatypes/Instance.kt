package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Instance(
    val id: InstanceId,
    val domain: String,
    val published: String,
    val updated: String? = null,
    val software: String? = null,
    val version: String? = null,
)
