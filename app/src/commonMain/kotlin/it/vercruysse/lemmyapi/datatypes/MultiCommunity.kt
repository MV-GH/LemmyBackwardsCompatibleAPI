package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class MultiCommunity(
    val id: MultiCommunityId,
    val creator_id: PersonId,
    val instance_id: InstanceId,
    val name: String,
    val title: String? = null,
    val summary: String? = null,
    val local: Boolean,
    val deleted: Boolean,
    val ap_id: String,
    val last_refreshed_at: String,
    val published_at: String,
    val updated_at: String? = null,
    val subscribers: Long,
    val subscribers_local: Long,
    val communities: Long,
    val sidebar: String? = null,
) : DatatypeRoot
