package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class GetSiteResponse(
    val site_view: SiteView,
    val admins: List<PersonView>,
    val version: String,
    val all_languages: List<Language>,
    val discussion_languages: List<LanguageId>,
    val blocked_urls: List<LocalSiteUrlBlocklist>,
    val tagline: Tagline? = null,
    /** Added in 1.0.0 */
    val oauth_providers: List<PublicOAuthProvider>,
    /** Added in 1.0.0 */
    val admin_oauth_providers: List<AdminOAuthProvider>,
    /** Added in 1.0.0 */
    val active_plugins: List<PluginMetadata>,
    val last_application_duration_seconds: Long? = null,
    /** Added in 1.0.0 */
    val captcha_enabled: Boolean,
) : DatatypeRoot
