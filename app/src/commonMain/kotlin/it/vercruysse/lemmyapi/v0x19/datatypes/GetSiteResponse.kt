package it.vercruysse.lemmyapi.v0x19.datatypes

import kotlinx.serialization.Serializable

@Serializable
data class GetSiteResponse(
    val site_view: SiteView,
    val admins: List<PersonView>,
    val version: String,
    val my_user: MyUserInfo? = null,
    val all_languages: List<Language>,
    val discussion_languages: List<LanguageId>,
    val taglines: List<Tagline>,
    val custom_emojis: List<CustomEmojiView>,
)
