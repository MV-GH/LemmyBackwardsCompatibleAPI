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
    val description: String? = null,
    val local: Boolean,
    val deleted: Boolean,
    val ap_id: String,
    val published_at: String,
    val updated_at: String? = null,
) : DatatypeRoot
