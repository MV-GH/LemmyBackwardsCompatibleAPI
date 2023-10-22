package v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class Site(
    val id: SiteId,
    val name: String,
    val sidebar: String? = null,
    val published: String,
    val updated: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val description: String? = null,
    val actor_id: String,
    val last_refreshed_at: String,
    val private_key: String? = null,
    val inbox_url: String,
    val public_key: String,
    val instance_id: InstanceId,
)
