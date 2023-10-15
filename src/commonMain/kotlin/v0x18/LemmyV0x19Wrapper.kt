package v0x18

import io.ktor.client.*
import pictrs.datatypes.UploadImage
import pictrs.datatypes.UploadImageResponse
import v0x18.datatypes.*
import v0x19.datatypes.*
import v0x19.datatypes.AddAdmin
import v0x19.datatypes.AddAdminResponse
import v0x19.datatypes.AddModToCommunity
import v0x19.datatypes.AddModToCommunityResponse
import v0x19.datatypes.ApproveRegistrationApplication
import v0x19.datatypes.BanFromCommunity
import v0x19.datatypes.BanFromCommunityResponse
import v0x19.datatypes.BanPerson
import v0x19.datatypes.BanPersonResponse
import v0x19.datatypes.BannedPersonsResponse
import v0x19.datatypes.BlockCommunity
import v0x19.datatypes.BlockCommunityResponse
import v0x19.datatypes.BlockPerson
import v0x19.datatypes.BlockPersonResponse
import v0x19.datatypes.ChangePassword
import v0x19.datatypes.CommentReplyResponse
import v0x19.datatypes.CommentReportResponse
import v0x19.datatypes.CommentResponse
import v0x19.datatypes.CommunityResponse
import v0x19.datatypes.CreateComment
import v0x19.datatypes.CreateCommentLike
import v0x19.datatypes.CreateCommentReport
import v0x19.datatypes.CreateCommunity
import v0x19.datatypes.CreateCustomEmoji
import v0x19.datatypes.CreatePost
import v0x19.datatypes.CreatePostLike
import v0x19.datatypes.CreatePostReport
import v0x19.datatypes.CreatePrivateMessage
import v0x19.datatypes.CreatePrivateMessageReport
import v0x19.datatypes.CreateSite
import v0x19.datatypes.CustomEmojiResponse
import v0x19.datatypes.DeleteAccount
import v0x19.datatypes.DeleteComment
import v0x19.datatypes.DeleteCommunity
import v0x19.datatypes.DeleteCustomEmoji
import v0x19.datatypes.DeleteCustomEmojiResponse
import v0x19.datatypes.DeletePost
import v0x19.datatypes.DeletePrivateMessage
import v0x19.datatypes.DistinguishComment
import v0x19.datatypes.EditComment
import v0x19.datatypes.EditCommunity
import v0x19.datatypes.EditCustomEmoji
import v0x19.datatypes.EditPost
import v0x19.datatypes.EditPrivateMessage
import v0x19.datatypes.EditSite
import v0x19.datatypes.FeaturePost
import v0x19.datatypes.FollowCommunity
import v0x19.datatypes.GetCaptchaResponse
import v0x19.datatypes.GetComment
import v0x19.datatypes.GetComments
import v0x19.datatypes.GetCommentsResponse
import v0x19.datatypes.GetCommunity
import v0x19.datatypes.GetCommunityResponse
import v0x19.datatypes.GetFederatedInstancesResponse
import v0x19.datatypes.GetModlog
import v0x19.datatypes.GetModlogResponse
import v0x19.datatypes.GetPersonDetails
import v0x19.datatypes.GetPersonDetailsResponse
import v0x19.datatypes.GetPersonMentions
import v0x19.datatypes.GetPersonMentionsResponse
import v0x19.datatypes.GetPost
import v0x19.datatypes.GetPostResponse
import v0x19.datatypes.GetPosts
import v0x19.datatypes.GetPostsResponse
import v0x19.datatypes.GetPrivateMessages
import v0x19.datatypes.GetReplies
import v0x19.datatypes.GetRepliesResponse
import v0x19.datatypes.GetReportCount
import v0x19.datatypes.GetReportCountResponse
import v0x19.datatypes.GetSiteMetadata
import v0x19.datatypes.GetSiteMetadataResponse
import v0x19.datatypes.GetSiteResponse
import v0x19.datatypes.GetUnreadCountResponse
import v0x19.datatypes.GetUnreadRegistrationApplicationCountResponse
import v0x19.datatypes.HideCommunity
import v0x19.datatypes.ListCommentReports
import v0x19.datatypes.ListCommentReportsResponse
import v0x19.datatypes.ListCommunities
import v0x19.datatypes.ListCommunitiesResponse
import v0x19.datatypes.ListPostReports
import v0x19.datatypes.ListPostReportsResponse
import v0x19.datatypes.ListPrivateMessageReports
import v0x19.datatypes.ListPrivateMessageReportsResponse
import v0x19.datatypes.ListRegistrationApplications
import v0x19.datatypes.ListRegistrationApplicationsResponse
import v0x19.datatypes.LockPost
import v0x19.datatypes.Login
import v0x19.datatypes.LoginResponse
import v0x19.datatypes.MarkCommentReplyAsRead
import v0x19.datatypes.MarkPersonMentionAsRead
import v0x19.datatypes.MarkPostAsRead
import v0x19.datatypes.MarkPrivateMessageAsRead
import v0x19.datatypes.PasswordChangeAfterReset
import v0x19.datatypes.PasswordReset
import v0x19.datatypes.PersonMentionResponse
import v0x19.datatypes.PostReportResponse
import v0x19.datatypes.PostResponse
import v0x19.datatypes.PrivateMessageReportResponse
import v0x19.datatypes.PrivateMessageResponse
import v0x19.datatypes.PrivateMessagesResponse
import v0x19.datatypes.PurgeComment
import v0x19.datatypes.PurgeCommunity
import v0x19.datatypes.PurgeItemResponse
import v0x19.datatypes.PurgePerson
import v0x19.datatypes.PurgePost
import v0x19.datatypes.Register
import v0x19.datatypes.RegistrationApplicationView
import v0x19.datatypes.RemoveComment
import v0x19.datatypes.RemoveCommunity
import v0x19.datatypes.RemovePost
import v0x19.datatypes.ResolveCommentReport
import v0x19.datatypes.ResolveObject
import v0x19.datatypes.ResolveObjectResponse
import v0x19.datatypes.ResolvePostReport
import v0x19.datatypes.ResolvePrivateMessageReport
import v0x19.datatypes.SaveComment
import v0x19.datatypes.SavePost
import v0x19.datatypes.SaveUserSettings
import v0x19.datatypes.Search
import v0x19.datatypes.SearchResponse
import v0x19.datatypes.SiteResponse
import v0x19.datatypes.TransferCommunity
import v0x19.datatypes.VerifyEmail

class LemmyV0x19Wrapper(ktor: HttpClient, auth: String? = null) : v0x19.LemmyApi {
    private val apiV18 = LemmyApiService(ktor, auth)
    private val transformer = Transformer(auth ?: "")

    override val version: String
        get() = apiV18.version

    override var auth: String? = auth
        set(value) {
            transformer.auth = value ?: ""
            field = value
            apiV18.auth = value // Not sure if this needed
        }

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    override suspend fun getSite(): Result<GetSiteResponse> {
        return apiV18.getSite(GetSite(auth)).map { transformer.toV0x19(it) }
    }

    /**
     * Create your site.
     *
     * @POST("site")
     */
    override suspend fun createSite(form: CreateSite): Result<SiteResponse> {
        return apiV18.createSite(transformer.toV0x18(form)).map { transformer.toV0x19(it) }
    }

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    override suspend fun editSite(form: EditSite): Result<SiteResponse> =
        apiV18.editSite(transformer.toV0x18(form)).map { transformer.toV0x19(it) }

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    override suspend fun getModlog(form: GetModlog): Result<GetModlogResponse> =
        apiV18.getModlog(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Search lemmy.
     *
     * @GET("search")
     */
    override suspend fun search(form: Search): Result<SearchResponse> =
        apiV18.search(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    override suspend fun resolveObject(form: ResolveObject): Result<ResolveObjectResponse> =
        apiV18.resolveObject(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    override suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse> =
        apiV18.getCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    override suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse> =
        apiV18.createCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    override suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse> =
        apiV18.editCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Hide a community from public view.
     *
     * @PUT("community/hide")
     */
    override suspend fun hideCommunity(form: HideCommunity): Result<CommunityResponse> =
        apiV18.hideCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    override suspend fun listCommunities(form: ListCommunities): Result<ListCommunitiesResponse> =
        apiV18.listCommunities(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    override suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse> =
        apiV18.followCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    override suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse> =
        apiV18.blockCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    override suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse> =
        apiV18.deleteCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    override suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse> =
        apiV18.removeCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    override suspend fun transferCommunity(form: TransferCommunity): Result<CommunityResponse> =
        apiV18.transferCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    override suspend fun banFromCommunity(form: BanFromCommunity): Result<BanFromCommunityResponse> =
        apiV18.banFromCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    override suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse> =
        apiV18.addModToCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    override suspend fun getFederatedInstances(): Result<GetFederatedInstancesResponse> =
        apiV18.getFederatedInstances(GetFederatedInstances(auth)).map(transformer::toV0x19)

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    override suspend fun getPost(form: GetPost): Result<GetPostResponse> =
        apiV18.getPost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    override suspend fun editPost(form: EditPost): Result<PostResponse> =
        apiV18.editPost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Create a post.
     *
     * @POST("post")
     */
    override suspend fun createPost(form: CreatePost): Result<PostResponse> =
        apiV18.createPost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    override suspend fun getPosts(form: GetPosts): Result<GetPostsResponse> =
        apiV18.getPosts(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    override suspend fun deletePost(form: DeletePost): Result<PostResponse> =
        apiV18.deletePost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    override suspend fun removePost(form: RemovePost): Result<PostResponse> =
        apiV18.removePost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    override suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse> =
        apiV18.markPostAsRead(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    override suspend fun lockPost(form: LockPost): Result<PostResponse> =
        apiV18.lockPost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    override suspend fun featurePost(form: FeaturePost): Result<PostResponse> =
        apiV18.featurePost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    override suspend fun createPostLike(form: CreatePostLike): Result<PostResponse> =
        apiV18.createPostLike(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    override suspend fun savePost(form: SavePost): Result<PostResponse> =
        apiV18.savePost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    override suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse> =
        apiV18.createPostReport(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    override suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse> =
        apiV18.resolvePostReport(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * List post reports.
     *
     * @GET("post/report/list")
     */
    override suspend fun listPostReports(form: ListPostReports): Result<ListPostReportsResponse> =
        apiV18.listPostReports(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    override suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse> =
        apiV18.getSiteMetadata(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    override suspend fun getComment(form: GetComment): Result<CommentResponse> =
        apiV18.getComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    override suspend fun createComment(form: CreateComment): Result<CommentResponse> =
        apiV18.createComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    override suspend fun editComment(form: EditComment): Result<CommentResponse> =
        apiV18.editComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    override suspend fun getComments(form: GetComments): Result<GetCommentsResponse> =
        apiV18.getComments(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    override suspend fun deleteComment(form: DeleteComment): Result<CommentResponse> =
        apiV18.deleteComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    override suspend fun removeComment(form: RemoveComment): Result<CommentResponse> =
        apiV18.removeComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Mark a comment as read.
     *
     * @POST("comment/mark_as_read")
     */
    override suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse> =
        apiV18.markCommentReplyAsRead(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    override suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse> =
        apiV18.distinguishComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    override suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse> =
        apiV18.createCommentLike(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    override suspend fun saveComment(form: SaveComment): Result<CommentResponse> =
        apiV18.saveComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    override suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse> =
        apiV18.createCommentReport(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    override suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse> =
        apiV18.resolveCommentReport(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * List comment reports.
     *
     * @GET("comment/report/list")
     */
    override suspend fun listCommentReports(form: ListCommentReports): Result<ListCommentReportsResponse> =
        apiV18.listCommentReports(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    override suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse> =
        apiV18.editPrivateMessage(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    override suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse> =
        apiV18.createPrivateMessage(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get / fetch private messages.
     *
     * @GET("private_message/list")
     */
    override suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse> =
        apiV18.getPrivateMessages(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    override suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse> =
        apiV18.deletePrivateMessage(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Mark a private message as read.
     *
     * @POST("private_message/mark_as_read")
     */
    override suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse> =
        apiV18.markPrivateMessageAsRead(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    override suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse> =
        apiV18.createPrivateMessageReport(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    override suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse> =
        apiV18.resolvePrivateMessageReport(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * List private message reports.
     *
     * @GET("private_message/report/list")
     */
    override suspend fun listPrivateMessageReports(form: ListPrivateMessageReports): Result<ListPrivateMessageReportsResponse> =
        apiV18.listPrivateMessageReports(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    override suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse> =
        apiV18.getPersonDetails(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    override suspend fun register(form: Register): Result<LoginResponse> =
        apiV18.register(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    override suspend fun getCaptcha(): Result<GetCaptchaResponse> =
        apiV18.getCaptcha(GetCaptcha(auth)).map(transformer::toV0x19)

    /**
     * Get mentions for your user.
     *
     * @GET("user/mention")
     */
    override suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse> =
        apiV18.getPersonMentions(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Mark a person mention as read.
     *
     * @POST("user/mention/mark_as_read")
     */
    override suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse> =
        apiV18.markPersonMentionAsRead(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get comment replies.
     *
     * @GET("user/replies")
     */
    override suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse> =
        apiV18.getReplies(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Ban a person from your site.
     *
     * @POST("user/ban")
     */
    override suspend fun banPerson(form: BanPerson): Result<BanPersonResponse> =
        apiV18.banPerson(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    override suspend fun getBannedPersons(): Result<BannedPersonsResponse> =
        apiV18.getBannedPersons(GetBannedPersons(auth ?: "")).map(transformer::toV0x19)

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    override suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse> =
        apiV18.blockPerson(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    override suspend fun login(form: Login): Result<LoginResponse> =
        apiV18.login(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    override suspend fun deleteAccount(form: DeleteAccount): Result<Unit> =
        apiV18.deleteAccount(transformer.toV0x18(form))

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    override suspend fun passwordReset(form: PasswordReset): Result<Unit> =
        apiV18.passwordReset(transformer.toV0x18(form))

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    override suspend fun passwordChangeAfterReset(form: PasswordChangeAfterReset): Result<Unit> =
        apiV18.passwordChangeAfterReset(transformer.toV0x18(form))

    /**
     * Mark all replies as read.
     *
     * @POST("user/mark_all_as_read")
     */
    override suspend fun markAllAsRead(): Result<GetRepliesResponse> =
        apiV18.markAllAsRead(MarkAllAsRead(auth ?: "")).map(transformer::toV0x19)

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    override suspend fun saveUserSettings(form: SaveUserSettings): Result<LoginResponse> =
        apiV18.saveUserSettings(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    override suspend fun changePassword(form: ChangePassword): Result<LoginResponse> =
        apiV18.changePassword(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get counts for your reports
     *
     * @GET("user/report_count")
     */
    override suspend fun getReportCount(form: GetReportCount): Result<GetReportCountResponse> =
        apiV18.getReportCount(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get your unread counts
     *
     * @GET("user/unread_count")
     */
    override suspend fun getUnreadCount(): Result<GetUnreadCountResponse> =
        apiV18.getUnreadCount(GetUnreadCount(auth ?: "")).map(transformer::toV0x19)

    /**
     * Verify your email
     *
     * @POST("user/verify_email")
     */
    override suspend fun verifyEmail(form: VerifyEmail): Result<Unit> =
        apiV18.verifyEmail(transformer.toV0x18(form))

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    override suspend fun leaveAdmin(): Result<GetSiteResponse> =
        apiV18.leaveAdmin(LeaveAdmin(auth ?: "")).map(transformer::toV0x19)

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    override suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse> =
        apiV18.addAdmin(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Get the unread registration applications count.
     *
     * @GET("admin/registration_application/count")
     */
    override suspend fun getUnreadRegistrationApplicationCount(): Result<GetUnreadRegistrationApplicationCountResponse> =
        apiV18.getUnreadRegistrationApplicationCount(GetUnreadRegistrationApplicationCount(auth ?: "")).map(transformer::toV0x19)

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    override suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<ListRegistrationApplicationsResponse> =
        apiV18.listRegistrationApplications(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    override suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationView> =
        apiV18.approveRegistrationApplication(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    override suspend fun purgePerson(form: PurgePerson): Result<PurgeItemResponse> =
        apiV18.purgePerson(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    override suspend fun purgeCommunity(form: PurgeCommunity): Result<PurgeItemResponse> =
        apiV18.purgeCommunity(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    override suspend fun purgePost(form: PurgePost): Result<PurgeItemResponse> =
        apiV18.purgePost(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    override suspend fun purgeComment(form: PurgeComment): Result<PurgeItemResponse> =
        apiV18.purgeComment(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    override suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse> =
        apiV18.editCustomEmoji(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    override suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse> =
        apiV18.createCustomEmoji(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    override suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<DeleteCustomEmojiResponse> =
        apiV18.deleteCustomEmoji(transformer.toV0x18(form)).map(transformer::toV0x19)

    /**
     * Block an instance.
     *
     * @POST("site/block")
     */
    override suspend fun blockInstance(form: BlockInstance): Result<BlockInstanceResponse> {
        TODO(" FEATURE FLAG")
    }

    /**
     * Generate a TOTP / two-factor secret.
     *
     * Afterwards you need to call `/user/totp/update` with a valid token to enable it.
     *
     * @POST("user/totp/generate")
     */
    override suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse> {
        TODO(" FEATURE FLAG")
    }

    /**
     * Enable / Disable TOTP / two-factor authentication.
     *
     * To enable, you need to first call `/user/totp/generate` and then pass a valid token to this.
     *
     * Disabling is only possible if 2FA was previously enabled. Again it is necessary to pass a valid token.
     *
     * @POST("user/totp/update")
     */
    override suspend fun updateTotp(form: UpdateTotp): Result<UpdateTotpResponse> {
        TODO(" FEATURE FLAG")
    }

    // PICTRS

    /**
     * Upload an image to the server.
     *
     * @POST(/pictrs/image)
     */
    override suspend fun uploadImage(form: UploadImage): Result<UploadImageResponse> = apiV18.uploadImage(form)

    /**
     * Delete an image from the server.
     *
     * @POST(/pictrs/image/delete)
     */
    override suspend fun deleteImage(relativeUrl: String): Result<Unit> = apiV18.deleteImage(relativeUrl)
}
