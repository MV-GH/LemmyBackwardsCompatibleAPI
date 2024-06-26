package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class InstanceBlockView(
    val person: Person,
    val instance: Instance,
    val site: Site? = null,
) : DatatypeRoot
