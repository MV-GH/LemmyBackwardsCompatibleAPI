package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class PluginMetadata(
    val name: String,
    val url: String? = null,
    val description: String? = null,
) : DatatypeRoot
