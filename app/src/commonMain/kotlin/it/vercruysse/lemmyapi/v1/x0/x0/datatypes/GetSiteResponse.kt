package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import kotlinx.serialization.Serializable

@Serializable
internal data class GetSiteResponse(
    val site_view: SiteView,
    val admins: List<PersonView>,
    val version: String,
    val all_languages: List<Language>,
    val discussion_languages: List<LanguageId>,
    val tagline: Tagline? = null,
    val oauth_providers: List<PublicOAuthProvider>,
    val admin_oauth_providers: List<OAuthProvider>,
    val blocked_urls: List<LocalSiteUrlBlocklist>,
    val image_upload_disabled: Boolean,
    val active_plugins: List<PluginMetadata>,
)
