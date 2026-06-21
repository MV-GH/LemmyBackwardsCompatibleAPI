package it.vercruysse.lemmyapi.v1.x0.x0.datatypes

import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.CommentSortType
import it.vercruysse.lemmyapi.enums.VoteShow
import kotlinx.serialization.Serializable

@Serializable
internal data class LocalUser(
    val id: LocalUserId,
    val person_id: PersonId,
    val email: SensitiveString? = null,
    val show_nsfw: Boolean,
    val theme: String,
    val default_post_sort_type: SortType /* "active" | "hot" | "new" | "old" | "top" | "most_comments" | "new_comments" | "controversial" | "scaled" */,
    val default_listing_type: ListingType /* "all" | "local" | "subscribed" | "moderator_view" | "suggested" */,
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
    val post_listing_mode: PostListingMode /* "list" | "card" | "small_card" */,
    val totp_2fa_enabled: Boolean,
    val animated_images_enabled: Boolean,
    val collapse_bot_comments: Boolean,
    val last_donation_notification_at: String,
    val private_messages_enabled: Boolean,
    val default_comment_sort_type: CommentSortType,
    val auto_mark_fetched_posts_as_read: Boolean,
    val hide_media: Boolean,
    val default_post_time_range_seconds: Long? = null,
    val show_score: Boolean,
    val show_upvotes: Boolean,
    val show_downvotes: VoteShow /* "show" | "show_for_others" | "hide" */,
    val show_upvote_percentage: Boolean,
    val show_person_votes: Boolean,
    val default_items_per_page: Long,
)
