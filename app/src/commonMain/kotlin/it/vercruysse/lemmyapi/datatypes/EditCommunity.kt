package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class EditCommunity(
    val community_id: CommunityId,
    val title: String? = null,
    /** Added in Lemmy 1.0.0 */
    val sidebar: String? = null,
    val summary: String? = null,
    val nsfw: Boolean? = null,
    val posting_restricted_to_mods: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val visibility: CommunityVisibility? /* "Public" | "LocalOnly" */ = null,
) : DatatypeRoot
