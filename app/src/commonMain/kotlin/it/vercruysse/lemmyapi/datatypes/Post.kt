package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class Post(
    override val id: PostId,
    val name: String,
    val url: String? = null,
    val body: String? = null,
    val creator_id: PersonId,
    val community_id: CommunityId,
    val removed: Boolean,
    val locked: Boolean,
    val published_at: String,
    val updated_at: String? = null,
    val deleted: Boolean,
    val nsfw: Boolean,
    val embed_title: String? = null,
    val embed_description: String? = null,
    val thumbnail_url: String? = null,
    val ap_id: String,
    val local: Boolean,
    val embed_video_url: String? = null,
    val language_id: LanguageId,
    val featured_community: Boolean,
    val featured_local: Boolean,
    val url_content_type: String? = null,
    val alt_text: String? = null,
    val scheduled_publish_time_at: String? = null,
    val newest_comment_time_at: String? = null,
    val comments: Long,
    val score: Long,
    val upvotes: Long,
    val downvotes: Long,
    val report_count: Long,
    val unresolved_report_count: Long,
    val federation_pending: Boolean,
    val embed_video_width: Long? = null,
    val embed_video_height: Long? = null,
) : DatatypeRoot, Identity
