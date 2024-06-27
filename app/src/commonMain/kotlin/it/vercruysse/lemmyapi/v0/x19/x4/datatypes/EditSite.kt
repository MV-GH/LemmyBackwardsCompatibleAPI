package it.vercruysse.lemmyapi.v0.x19.x4.datatypes

import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.RegistrationMode
import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class EditSite(
    val name: String? = null,
    val sidebar: String? = null,
    val description: String? = null,
    val icon: String? = null,
    val banner: String? = null,
    val enable_downvotes: Boolean? = null,
    val enable_nsfw: Boolean? = null,
    val community_creation_admin_only: Boolean? = null,
    val require_email_verification: Boolean? = null,
    val application_question: String? = null,
    val private_instance: Boolean? = null,
    val default_theme: String? = null,
    val default_post_listing_type: ListingType? /* "All" | "Local" | "Subscribed" | "ModeratorView" */ = null,
    val default_sort_type: SortType? /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */ = null,
    val legal_information: String? = null,
    val application_email_admins: Boolean? = null,
    val hide_modlog_mod_names: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val slur_filter_regex: String? = null,
    val actor_name_max_length: Long? = null,
    val rate_limit_message: Long? = null,
    val rate_limit_message_per_second: Long? = null,
    val rate_limit_post: Long? = null,
    val rate_limit_post_per_second: Long? = null,
    val rate_limit_register: Long? = null,
    val rate_limit_register_per_second: Long? = null,
    val rate_limit_image: Long? = null,
    val rate_limit_image_per_second: Long? = null,
    val rate_limit_comment: Long? = null,
    val rate_limit_comment_per_second: Long? = null,
    val rate_limit_search: Long? = null,
    val rate_limit_search_per_second: Long? = null,
    val federation_enabled: Boolean? = null,
    val federation_debug: Boolean? = null,
    val captcha_enabled: Boolean? = null,
    val captcha_difficulty: String? = null,
    val allowed_instances: List<String>? = null,
    val blocked_instances: List<String>? = null,
    val blocked_urls: List<String>? = null,
    val taglines: List<String>? = null,
    val registration_mode: RegistrationMode? /* "Closed" | "RequireApplication" | "Open" */ = null,
    val reports_email_admins: Boolean? = null,
    val content_warning: String? = null,
    val default_post_listing_mode: PostListingMode? /* "List" | "Card" | "SmallCard" */ = null,
)
