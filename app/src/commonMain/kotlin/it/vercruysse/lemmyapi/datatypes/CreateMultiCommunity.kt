package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreateMultiCommunity(
    val name: String,
    val title: String? = null,
    val description: String? = null,
) : DatatypeRoot
