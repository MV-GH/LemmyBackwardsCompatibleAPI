package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class AdminBlockInstanceParams(
    val instance: String,
    val block: Boolean,
    val reason: String,
    val expires_at: Long? = null,
) : DatatypeRoot
