package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AdminAllowInstanceParams(
    val instance: String,
    val allow: Boolean,
    val reason: String? = null,
): DatatypeRoot
