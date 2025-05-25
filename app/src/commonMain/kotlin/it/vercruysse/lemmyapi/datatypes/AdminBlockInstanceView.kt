package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AdminBlockInstanceView(
    val admin_block_instance: AdminBlockInstance,
    val instance: Instance,
    val admin: Person? = null,
): DatatypeRoot
