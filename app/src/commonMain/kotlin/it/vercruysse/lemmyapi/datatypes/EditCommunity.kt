package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.dto.CommunityVisibility
import kotlinx.serialization.Serializable

import it.vercruysse.lemmyapi.CommonParcelize

@CommonParcelize
@Serializable
data class EditCommunity(
    val community_id: CommunityId,
    val title: String? = null,
    /** Added in Lemmy 1.0.0 */
    val sidebar: String? = null,
    val description: String? = null,
    /** Removed in Lemmy 1.0.0 */
    val icon: String? = null,
    /** Removed in Lemmy 1.0.0 */
    val banner: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "Public" | "LocalOnly" */ = null,
) : DatatypeRoot
