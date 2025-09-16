package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Site(
    override val id: SiteId,
    val name: String,
    val sidebar: String? = null,
    val published_at: String,
    val updated_at: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val description: String? = null,
    val ap_id: String,
    val last_refreshed_at: String,
    val inbox_url: String,
    val public_key: String? = null,
    val instance_id: InstanceId,
    val content_warning: String? = null,
) : DatatypeRoot, Identity
