package it.vercruysse.lemmyapi.datatypes

import it.vercruysse.lemmyapi.CommonParcelize
import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.Identity
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PostListingMode
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.CommentSortType
import it.vercruysse.lemmyapi.enums.VoteShow
import kotlinx.serialization.Serializable

@CommonParcelize
@Serializable
data class LocalUser(
    override val id: LocalUserId,
    val person_id: PersonId,
    val email: String? = null,
    val show_nsfw: Boolean,
    val theme: String,
    val default_post_sort_type: SortType /* "Active" | "Hot" | "New" | "Old" | "TopDay" | "TopWeek" | "TopMonth" | "TopYear" | "TopAll" | "MostComments" | "NewComments" | "TopHour" | "TopSixHour" | "TopTwelveHour" | "TopThreeMonths" | "TopSixMonths" | "TopNineMonths" | "Controversial" | "Scaled" */,
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
    val animated_images_enabled: Boolean,
    /** Added in 1.0.0 */
    val private_messages_enabled: Boolean,
    val collapse_bot_comments: Boolean,
    /** Added in 1.0.0 */
    val default_comment_sort_type: CommentSortType,
    /** Added in 1.0.0 */
    val auto_mark_fetched_posts_as_read: Boolean,
    /** Added in 0.19.11 */
    val last_donation_notification_at: String,
    /** Added in 1.0.0 */
    val hide_media: Boolean,
    /** Added in 1.0.0 */
    val default_post_time_range_seconds: Long? = null,
    val show_score: Boolean,
    val show_upvotes: Boolean,
    val show_downvotes: VoteShow /* "Show" | "ShowForOthers" | "Hide" */,
    val show_upvote_percentage: Boolean,
    /** Added in 1.0.0 */
    val show_person_votes: Boolean,
    /** Added in 1.0.0 */
    val default_items_per_page: Long,
) : DatatypeRoot, Identity
