package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class Instance(
    val id: InstanceId,
    val domain: String,
    val published_at: String,
    val updated_at: String? = null,
    val software: String? = null,
    val version: String? = null,
) : DatatypeRoot
