package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Instance(
    val id: InstanceId,
    val domain: String,
    val published_at: String,
    val updated_at: String? = null,
    val software: String? = null,
    val version: String? = null,
)
