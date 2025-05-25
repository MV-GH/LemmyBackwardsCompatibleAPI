package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.TagId

@CommonParcelize
@Serializable
data class CreatePost(
    val name: String,
    val community_id: CommunityId,
    val url: String? = null,
    val body: String? = null,
    val alt_text: String? = null,
    val honeypot: String? = null,
    val nsfw: Boolean? = null,
    val language_id: LanguageId? = null,
    val custom_thumbnail: String? = null,
    /** Added in Lemmy 1.0.0 */
    val tags: List<TagId>? = null,
    /** Added in Lemmy 1.0.0 */
    val scheduled_publish_time: Long? = null,
) : DatatypeRoot
