package it.vercruysse.lemmyapi.v0.x19.x11

import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.AuthBaseClient
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings
import it.vercruysse.lemmyapi.v0.x19.x11.datatypes.*

internal abstract class LemmyApiRouter(client: HttpClient, auth: String?) : AuthBaseClient(client, auth) {

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    abstract suspend fun getSite(): Result<GetSiteResponse>

    /**
     * Create your site.
     *
     * @POST("site")
     */
    abstract suspend fun createSite(form: CreateSite): Result<SiteResponse>

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    abstract suspend fun editSite(form: EditSite): Result<SiteResponse>

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    abstract suspend fun getModlog(form: GetModlog): Result<GetModlogResponse>

    /**
     * Search lemmy.
     *
     * @GET("search")
     */
    abstract suspend fun search(form: Search): Result<SearchResponse>

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    abstract suspend fun resolveObject(form: ResolveObject): Result<ResolveObjectResponse>

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    abstract suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    abstract suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse>

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    abstract suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse>

    /**
     * Hide a community from public / "All" view. Admins only.
     *
     * @PUT("community/hide")
     */
    abstract suspend fun hideCommunity(form: HideCommunity): Result<Unit>

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    abstract suspend fun listCommunities(form: ListCommunities): Result<ListCommunitiesResponse>

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    abstract suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    abstract suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse>

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    abstract suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse>

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    abstract suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse>

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    abstract suspend fun transferCommunity(form: TransferCommunity): Result<CommunityResponse>

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    abstract suspend fun banFromCommunity(form: BanFromCommunity): Result<BanFromCommunityResponse>

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    abstract suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse>

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    abstract suspend fun getFederatedInstances(): Result<GetFederatedInstancesResponse>

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    abstract suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    abstract suspend fun editPost(form: EditPost): Result<PostResponse>

    /**
     * Create a post.
     *
     * @POST("post")
     */
    abstract suspend fun createPost(form: CreatePost): Result<PostResponse>

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    abstract suspend fun getPosts(form: GetPosts): Result<GetPostsResponse>

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    abstract suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    abstract suspend fun removePost(form: RemovePost): Result<PostResponse>

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    abstract suspend fun markPostAsRead(form: MarkPostAsRead): Result<Unit>

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    abstract suspend fun lockPost(form: LockPost): Result<PostResponse>

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    abstract suspend fun featurePost(form: FeaturePost): Result<PostResponse>

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    abstract suspend fun createPostLike(form: CreatePostLike): Result<PostResponse>

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    abstract suspend fun savePost(form: SavePost): Result<PostResponse>

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    abstract suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    abstract suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse>

    /**
     * List post reports.
     *
     * @GET("post/report/list")
     */
    abstract suspend fun listPostReports(form: ListPostReports): Result<ListPostReportsResponse>

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    abstract suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    abstract suspend fun getComment(form: GetComment): Result<CommentResponse>

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    abstract suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    abstract suspend fun editComment(form: EditComment): Result<CommentResponse>

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    abstract suspend fun getComments(form: GetComments): Result<GetCommentsResponse>

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    abstract suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    abstract suspend fun removeComment(form: RemoveComment): Result<CommentResponse>

    /**
     * Mark a comment as read.
     *
     * @POST("comment/mark_as_read")
     */
    abstract suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse>

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    abstract suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse>

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    abstract suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse>

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    abstract suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    abstract suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    abstract suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse>

    /**
     * List comment reports.
     *
     * @GET("comment/report/list")
     */
    abstract suspend fun listCommentReports(form: ListCommentReports): Result<ListCommentReportsResponse>

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    abstract suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse>

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    abstract suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Get / fetch private messages.
     *
     * @GET("private_message/list")
     */
    abstract suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse>

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    abstract suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Mark a private message as read.
     *
     * @POST("private_message/mark_as_read")
     */
    abstract suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse>

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    abstract suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    abstract suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * List private message reports.
     *
     * @GET("private_message/report/list")
     */
    abstract suspend fun listPrivateMessageReports(form: ListPrivateMessageReports): Result<ListPrivateMessageReportsResponse>

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    abstract suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    abstract suspend fun register(form: Register): Result<LoginResponse>

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    abstract suspend fun getCaptcha(): Result<GetCaptchaResponse>

    /**
     * Get mentions for your user.
     *
     * @GET("user/mention")
     */
    abstract suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse>

    /**
     * Mark a person mention as read.
     *
     * @POST("user/mention/mark_as_read")
     */
    abstract suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse>

    /**
     * Get comment replies.
     *
     * @GET("user/replies")
     */
    abstract suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse>

    /**
     * Ban a person from your site.
     *
     * @POST("user/ban")
     */
    abstract suspend fun banPerson(form: BanPerson): Result<BanPersonResponse>

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    abstract suspend fun getBannedPersons(): Result<BannedPersonsResponse>

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    abstract suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse>

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    abstract suspend fun login(form: Login): Result<LoginResponse>

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    abstract suspend fun deleteAccount(form: DeleteAccount): Result<Unit>

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    abstract suspend fun resetPassword(form: PasswordReset): Result<Unit>

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    abstract suspend fun changePasswordAfterReset(form: PasswordChangeAfterReset): Result<Unit>

    /**
     * Mark all replies as read.
     *
     * @POST("user/mark_all_as_read")
     */
    abstract suspend fun markAllAsRead(): Result<GetRepliesResponse>

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    abstract suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit>

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    abstract suspend fun changePassword(form: ChangePassword): Result<LoginResponse>

    /**
     * Get counts for your reports
     *
     * @GET("user/report_count")
     */
    abstract suspend fun getReportCount(form: GetReportCount): Result<GetReportCountResponse>

    /**
     * Get your unread counts
     *
     * @GET("user/unread_count")
     */
    abstract suspend fun getUnreadCount(): Result<GetUnreadCountResponse>

    /**
     * Verify your email
     *
     * @POST("user/verify_email")
     */
    abstract suspend fun verifyEmail(form: VerifyEmail): Result<Unit>

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    abstract suspend fun leaveAdmin(): Result<GetSiteResponse>

    /**
     * Mark donation dialog as shown.
     *
     * @POST("user/donation_dialog_shown")
     */
    abstract suspend fun markDonationDialogShown(): Result<Unit>

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    abstract suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse>

    /**
     * Get the unread registration applications count.
     *
     * @GET("admin/registration_application/count")
     */
    abstract suspend fun getUnreadRegistrationApplicationCount(): Result<GetUnreadRegistrationApplicationCountResponse>

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    abstract suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<ListRegistrationApplicationsResponse>

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    abstract suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse>

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    abstract suspend fun purgePerson(form: PurgePerson): Result<Unit>

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    abstract suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit>

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    abstract suspend fun purgePost(form: PurgePost): Result<Unit>

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    abstract suspend fun purgeComment(form: PurgeComment): Result<Unit>

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    abstract suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    abstract suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    abstract suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit>

    /**
     * Block an instance.
     *
     * @POST("site/block")
     */
    abstract suspend fun blockInstance(form: BlockInstance): Result<BlockInstanceResponse>

    /**
     * Generate a TOTP / two-factor secret.
     *
     * Afterwards you need to call `/user/totp/update` with a valid token to enable it.
     *
     * @POST("user/totp/generate")
     */
    abstract suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse>

    /**
     * Enable / Disable TOTP / two-factor authentication.
     *
     * To enable, you need to first call `/user/totp/generate` and then pass a valid token to this.
     *
     * Disabling is only possible if 2FA was previously enabled. Again it is necessary to pass a valid token.
     *
     * @POST("user/totp/update")
     */
    abstract suspend fun updateTotp(form: UpdateTotp): Result<UpdateTotpResponse>

    /**
     * Export a backup of your user settings, including your saved content,
     * followed communities, and blocks.
     *
     * @GET("user/export_settings")
     */
    abstract suspend fun exportUserSettings(): Result<ExportUserSettingsResponse>

    /**
     * Import a backup of your user settings.
     *
     * @POST("user/import_settings")
     */
    abstract suspend fun importUserSettings(form: ImportUserSettings): Result<Unit>

    /**
     * List login tokens for your user
     *
     * @GET("user/list_logins")
     */
    abstract suspend fun listLogins(): Result<List<LoginToken>>

    /**
     * Returns an error message if your auth token is invalid
     *
     * @GET("user/validate_auth")
     */
    abstract suspend fun validateAuth(): Result<Unit>

    /**
     * Invalidate the currently used auth token.
     *
     * @POST("user/logout")
     */
    abstract suspend fun logout(): Result<Unit>

    /**
     * List a post's likes. Admin-only.
     *
     * @GET("post/like/list")
     */
    abstract suspend fun listPostLikes(form: ListPostLikes): Result<ListPostLikesResponse>

    /**
     * List a comment's likes. Admin-only.
     *
     * @GET("comment/like/list")
     */
    abstract suspend fun listCommentLikes(form: ListCommentLikes): Result<ListCommentLikesResponse>

    /**
     * List all the media for your user
     *
     * @GET("account/list_media")
     */
    abstract suspend fun listMedia(form: ListMedia): Result<ListMediaResponse>

    /**
     * List all the media known to your instance.
     *
     * @GET("admin/list_all_media")
     */
    abstract suspend fun listAllMedia(form: ListMedia): Result<ListMediaResponse>

    /**
     * Hide a post from list views.
     *
     * @POST("post/hide")
     */
    abstract suspend fun hidePost(form: HidePost): Result<Unit>

    /**
     * Get the application a user submitted when they first registered their account
     *
     * @GET("admin/registration_application")
     */
    abstract suspend fun getRegistrationApplication(form: GetRegistrationApplication): Result<RegistrationApplicationResponse>
}
