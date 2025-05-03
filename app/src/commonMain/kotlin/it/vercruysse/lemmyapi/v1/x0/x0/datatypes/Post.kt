package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class Post(
    val id: PostId,
    val name: String,
    val url: DbUrl? = null,
    val body: String? = null,
    val creator_id: PersonId,
    val community_id: CommunityId,
    val removed: Boolean,
    val locked: Boolean,
    val published: String,
    val updated: String? = null,
    val deleted: Boolean,
    val nsfw: Boolean,
    val embed_title: String? = null,
    val embed_description: String? = null,
    val thumbnail_url: DbUrl? = null,
    val ap_id: DbUrl,
    val local: Boolean,
    val embed_video_url: DbUrl? = null,
    val language_id: LanguageId,
    val featured_community: Boolean,
    val featured_local: Boolean,
    val url_content_type: String? = null,
    val alt_text: String? = null,
    val scheduled_publish_time: String? = null,
    val comments: Long,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val newest_comment_time: String,
    val report_count: Long,
    val unresolved_report_count: Long,
    val federation_pending: Boolean,
)
