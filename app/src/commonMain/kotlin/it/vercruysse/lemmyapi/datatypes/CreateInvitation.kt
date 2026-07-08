package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class CreateInvitation(
    val max_uses: Long? = null,
    val expires_at: String? = null,
) : DatatypeRoot
