package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class InstanceActions(
    val blocked_communities_at: String? = null,
    val received_ban_at: String? = null,
    val ban_expires_at: String? = null,
    val blocked_persons_at: String? = null,
): DatatypeRoot
