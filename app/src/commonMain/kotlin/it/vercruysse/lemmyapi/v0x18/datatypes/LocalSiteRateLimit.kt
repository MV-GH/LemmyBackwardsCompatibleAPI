package it.vercruysse.lemmyapi.v0x18.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class LocalSiteRateLimit(
    val id: Long,
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
)
