package v0x17

import LemmyApiBase
import v0x18.datatypes.*
import v0x17.datatypes.GetSiteResponse

// The only breaking change with v0.18 really is the that taglines were optional
interface LemmyApi : LemmyApiBase {

    override val version: String
        get() = "0.17"

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    suspend fun getSite(form: GetSite): Result<GetSiteResponse>

    /**
     * Create your site.
     *
     * @POST("site")
     */
    suspend fun createSite(form: CreateSite): Result<SiteResponse>

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    suspend fun editSite(form: EditSite): Result<SiteResponse>

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    suspend fun getModlog(form: GetModlog): Result<GetModlogResponse>

    /**
     * Search lemmy.
     *
     * @GET("search")
     */
    suspend fun search(form: Search): Result<SearchResponse>

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    suspend fun resolveObject(form: ResolveObject): Result<ResolveObjectResponse>

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse>

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse>

    /**
     * [MANUAL] Hide a community from the feed
     *
     * @PUT("community/hide")
     */
    suspend fun hideCommunity(form: HideCommunity): Result<CommunityResponse>

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    suspend fun listCommunities(form: ListCommunities): Result<ListCommunitiesResponse>

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse>

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse>

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse>

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    suspend fun transferCommunity(form: TransferCommunity): Result<CommunityResponse>

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    suspend fun banFromCommunity(form: BanFromCommunity): Result<BanFromCommunityResponse>

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse>

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    suspend fun getFederatedInstances(form: GetFederatedInstances): Result<GetFederatedInstancesResponse>

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    suspend fun editPost(form: EditPost): Result<PostResponse>

    /**
     * Create a post.
     *
     * @POST("post")
     */
    suspend fun createPost(form: CreatePost): Result<PostResponse>

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    suspend fun getPosts(form: GetPosts): Result<GetPostsResponse>

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    suspend fun removePost(form: RemovePost): Result<PostResponse>

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse>

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    suspend fun lockPost(form: LockPost): Result<PostResponse>

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    suspend fun featurePost(form: FeaturePost): Result<PostResponse>

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    suspend fun createPostLike(form: CreatePostLike): Result<PostResponse>

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    suspend fun savePost(form: SavePost): Result<PostResponse>

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse>

    /**
     * List post reports.
     *
     * @GET("post/report/list")
     */
    suspend fun listPostReports(form: ListPostReports): Result<ListPostReportsResponse>

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    suspend fun getComment(form: GetComment): Result<CommentResponse>

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    suspend fun editComment(form: EditComment): Result<CommentResponse>

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    suspend fun getComments(form: GetComments): Result<GetCommentsResponse>

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    suspend fun removeComment(form: RemoveComment): Result<CommentResponse>

    /**
     * Mark a comment as read.
     *
     * @POST("comment/mark_as_read")
     */
    suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse>

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse>

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse>

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse>

    /**
     * List comment reports.
     *
     * @GET("comment/report/list")
     */
    suspend fun listCommentReports(form: ListCommentReports): Result<ListCommentReportsResponse>

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse>

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Get / fetch private messages.
     *
     * @GET("private_message/list")
     */
    suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse>

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Mark a private message as read.
     *
     * @POST("private_message/mark_as_read")
     */
    suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse>

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse>

    /**
     * List private message reports.
     *
     * @GET("private_message/report/list")
     */
    suspend fun listPrivateMessageReports(form: ListPrivateMessageReports): Result<ListPrivateMessageReportsResponse>

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    suspend fun register(form: Register): Result<LoginResponse>

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    suspend fun getCaptcha(form: GetCaptcha): Result<GetCaptchaResponse>

    /**
     * Get mentions for your user.
     *
     * @GET("user/mention")
     */
    suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse>

    /**
     * Mark a person mention as read.
     *
     * @POST("user/mention/mark_as_read")
     */
    suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse>

    /**
     * Get comment replies.
     *
     * @GET("user/replies")
     */
    suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse>

    /**
     * Ban a person from your site.
     *
     * @POST("user/ban")
     */
    suspend fun banPerson(form: BanPerson): Result<BanPersonResponse>

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    suspend fun getBannedPersons(form: GetBannedPersons): Result<BannedPersonsResponse>

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse>

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    suspend fun login(form: Login): Result<LoginResponse>

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    suspend fun deleteAccount(form: DeleteAccount): Result<Unit>

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    suspend fun passwordReset(form: PasswordReset): Result<Unit>

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    suspend fun passwordChangeAfterReset(form: PasswordChangeAfterReset): Result<Unit>

    /**
     * Mark all replies as read.
     *
     * @POST("user/mark_all_as_read")
     */
    suspend fun markAllAsRead(form: MarkAllAsRead): Result<GetRepliesResponse>

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    suspend fun saveUserSettings(form: SaveUserSettings): Result<LoginResponse>

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    suspend fun changePassword(form: ChangePassword): Result<LoginResponse>

    /**
     * Get counts for your reports
     *
     * @GET("user/report_count")
     */
    suspend fun getReportCount(form: GetReportCount): Result<GetReportCountResponse>

    /**
     * Get your unread counts
     *
     * @GET("user/unread_count")
     */
    suspend fun getUnreadCount(form: GetUnreadCount): Result<GetUnreadCountResponse>

    /**
     * Verify your email
     *
     * @POST("user/verify_email")
     */
    suspend fun verifyEmail(form: VerifyEmail): Result<Unit>

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    suspend fun leaveAdmin(form: LeaveAdmin): Result<GetSiteResponse>

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse>

    /**
     * Get the unread registration applications count.
     *
     * @GET("admin/registration_application/count")
     */
    suspend fun getUnreadRegistrationApplicationCount(form: GetUnreadRegistrationApplicationCount): Result<GetUnreadRegistrationApplicationCountResponse>

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<ListRegistrationApplicationsResponse>

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationView>

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    suspend fun purgePerson(form: PurgePerson): Result<PurgeItemResponse>

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    suspend fun purgeCommunity(form: PurgeCommunity): Result<PurgeItemResponse>

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    suspend fun purgePost(form: PurgePost): Result<PurgeItemResponse>

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    suspend fun purgeComment(form: PurgeComment): Result<PurgeItemResponse>

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse>

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<DeleteCustomEmojiResponse>
}
