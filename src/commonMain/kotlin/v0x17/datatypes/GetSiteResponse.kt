package v0x17.datatypes

import kotlinx.serialization.Serializable
import v0x18.datatypes.*

@Serializable
data class GetSiteResponse(
    val site_view: SiteView,
    val admins: List<PersonView>,
    val version: String,
    val my_user: MyUserInfo? = null,
    val all_languages: List<Language>,
    val discussion_languages: List<LanguageId>,
    val taglines: List<Tagline>? = null,
    val custom_emojis: List<CustomEmojiView>,
)
