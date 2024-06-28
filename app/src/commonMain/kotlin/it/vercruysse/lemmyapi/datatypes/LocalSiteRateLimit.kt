package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class LocalSiteRateLimit(
    val local_site_id: LocalSiteId,
    val message: Long,
    val message_per_second: Long,
    val post: Long,
    val post_per_second: Long,
    val register: Long,
    val register_per_second: Long,
    val image: Long,
    val image_per_second: Long,
    val comment: Long,
    val comment_per_second: Long,
    val search: Long,
    val search_per_second: Long,
    val published: String,
    val updated: String? = null,
    val import_user_settings: Long,
    val import_user_settings_per_second: Long,
) : DatatypeRoot
