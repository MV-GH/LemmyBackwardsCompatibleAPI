package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class AdminBlockInstanceView(
    val admin_block_instance: AdminBlockInstance,
    val instance: Instance,
    val admin: Person? = null,
)
