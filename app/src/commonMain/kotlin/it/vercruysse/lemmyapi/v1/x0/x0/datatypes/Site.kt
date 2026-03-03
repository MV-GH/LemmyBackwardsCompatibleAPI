package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Site(
    val id: SiteId,
    val name: String,
    val sidebar: String? = null,
    val published_at: String,
    val updated_at: String? = null,
    val icon: DbUrl? = null,
    val banner: DbUrl? = null,
    val summary: String? = null,
    val ap_id: DbUrl,
    val last_refreshed_at: String,
    val inbox_url: DbUrl,
    val public_key: String,
    val instance_id: InstanceId,
    val content_warning: String? = null,
)
