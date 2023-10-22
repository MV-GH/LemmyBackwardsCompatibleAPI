package v0x19.datatypes

import dto.RegistrationMode
import dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
data class CreateSite(
    val name: String,
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
    val legal_information: String? = null,
    val application_email_admins: Boolean? = null,
    val hide_modlog_mod_names: Boolean? = null,
    val discussion_languages: List<LanguageId>? = null,
    val slur_filter_regex: String? = null,
    val actor_name_max_length: Int? = null,
    val rate_limit_message: Int? = null,
    val rate_limit_message_per_second: Int? = null,
    val rate_limit_post: Int? = null,
    val rate_limit_post_per_second: Int? = null,
    val rate_limit_register: Int? = null,
    val rate_limit_register_per_second: Int? = null,
    val rate_limit_image: Int? = null,
    val rate_limit_image_per_second: Int? = null,
    val rate_limit_comment: Int? = null,
    val rate_limit_comment_per_second: Int? = null,
    val rate_limit_search: Int? = null,
    val rate_limit_search_per_second: Int? = null,
    val federation_enabled: Boolean? = null,
    val federation_debug: Boolean? = null,
    val captcha_enabled: Boolean? = null,
    val captcha_difficulty: String? = null,
    val allowed_instances: List<String>? = null,
    val blocked_instances: List<String>? = null,
    val taglines: List<String>? = null,
    val registration_mode: RegistrationMode? /* "Closed" | "RequireApplication" | "Open" */ = null,
)
