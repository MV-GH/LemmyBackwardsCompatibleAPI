package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.PostListingMode
import it.vercruysse.lemmyapi.dto.ListingType
import kotlinx.serialization.Serializable

@Serializable
internal data class LocalUser(
    val id: LocalUserId,
    val person_id: PersonId,
    val email: SensitiveString? = null,
    val show_nsfw: Boolean,
    val theme: String,
    val default_post_sort_type: SortType /* "Active" | "Hot" | "New" | "Old" | "Top" | "MostComments" | "NewComments" | "Controversial" | "Scaled" */,
    val default_listing_type: ListingType /* "All" | "Local" | "Subscribed" | "ModeratorView" */,
    val interface_language: String,
    val show_avatars: Boolean,
    val send_notifications_to_email: Boolean,
    val show_bot_accounts: Boolean,
    val show_read_posts: Boolean,
    val email_verified: Boolean,
    val accepted_application: Boolean,
    val open_links_in_new_tab: Boolean,
    val blur_nsfw: Boolean,
    val infinite_scroll_enabled: Boolean,
    val admin: Boolean,
    val post_listing_mode: PostListingMode /* "List" | "Card" | "SmallCard" */,
    val totp_2fa_enabled: Boolean,
    val enable_keyboard_navigation: Boolean,
    val enable_animated_images: Boolean,
    val enable_private_messages: Boolean,
    val collapse_bot_comments: Boolean,
    val default_comment_sort_type: SortType /* "Hot" | "Top" | "New" | "Old" | "Controversial" */,
    val auto_mark_fetched_posts_as_read: Boolean,
    val last_donation_notification: String,
    val hide_media: Boolean,
    val default_post_time_range_seconds: Long? = null,
    val show_score: Boolean,
    val show_upvotes: Boolean,
    val show_downvotes: Boolean,
    val show_upvote_percentage: Boolean,
)
