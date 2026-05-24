package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LocalSiteRateLimit(
    val local_site_id: LocalSiteId,
    val message_max_requests: Long,
    val message_interval_seconds: Long,
    val post_max_requests: Long,
    val post_interval_seconds: Long,
    val register_max_requests: Long,
    val register_interval_seconds: Long,
    val image_max_requests: Long,
    val image_interval_seconds: Long,
    val comment_max_requests: Long,
    val comment_interval_seconds: Long,
    val search_max_requests: Long,
    val search_interval_seconds: Long,
    val published_at: String,
    val updated_at: String? = null,
    val import_user_settings_max_requests: Long,
    val import_user_settings_interval_seconds: Long,
) : DatatypeRoot
