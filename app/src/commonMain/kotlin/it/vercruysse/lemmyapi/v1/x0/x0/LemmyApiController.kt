package it.vercruysse.lemmyapi.v1.x0.x0

import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings
import it.vercruysse.lemmyapi.utils.addQueryParams
import it.vercruysse.lemmyapi.utils.deleteResult
import it.vercruysse.lemmyapi.utils.getResult
import it.vercruysse.lemmyapi.utils.postResult
import it.vercruysse.lemmyapi.utils.postUploadResult
import it.vercruysse.lemmyapi.utils.putResult
import it.vercruysse.lemmyapi.v1.x0.x0.datatypes.*

internal class LemmyApiController(client: HttpClient, auth: String?) :
    LemmyApiRouter(
        client,
        auth,
    ) {

    /** @GET("site") */
    override suspend fun getSite(): Result<GetSiteResponse> =
        client.getResult("site")

    /** @POST("site") */
    override suspend fun createSite(form: CreateSite): Result<SiteResponse> =
        client.postResult("site", form)

    /** @PUT("site") */
    override suspend fun editSite(form: EditSite): Result<SiteResponse> =
        client.putResult("site", form)

    /** @DELETE("site/banner") */
    override suspend fun deleteSiteBanner(): Result<Unit> =
        client.deleteResult("site/banner")

    /** @DELETE("site/icon") */
    override suspend fun deleteSiteIcon(): Result<Unit> =
        client.deleteResult("site/icon")

    /** @GET("modlog") */
    override suspend fun getModlog(form: GetModlog): Result<PagedResponse<ModlogView>> =
        client.getResult("modlog", form)

    /** @GET("search") */
    override suspend fun search(form: Search): Result<SearchResponse> =
        client.getResult("search", form)

    /** @GET("resolve_object") */
    override suspend fun resolveObject(form: ResolveObject): Result<SearchResponse> =
        client.getResult("resolve_object", form)

    /** @GET("community") */
    override suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse> =
        client.getResult("community", form)

    /** @POST("community") */
    override suspend fun createCommunity(form: CreateCommunity): Result<CommunityResponse> =
        client.postResult("community", form)

    /** @PUT("community") */
    override suspend fun editCommunity(form: EditCommunity): Result<CommunityResponse> =
        client.putResult("community", form)

    /** @DELETE("community") */
    override suspend fun deleteCommunity(form: DeleteCommunity): Result<CommunityResponse> =
        client.deleteResult("community", form)

    /** @PUT("community/hide") */
    override suspend fun hideCommunity(form: HideCommunity): Result<Unit> =
        client.putResult("community/hide", form)

    /** @GET("community/list") */
    override suspend fun listCommunities(form: ListCommunities): Result<PagedResponse<CommunityView>> =
        client.getResult("community/list", form)

    /** @POST("community/follow") */
    override suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse> =
        client.postResult("community/follow", form)

    /** @POST("community/remove") */
    override suspend fun removeCommunity(form: RemoveCommunity): Result<CommunityResponse> =
        client.postResult("community/remove", form)

    /** @POST("community/transfer") */
    override suspend fun transferCommunity(form: TransferCommunity): Result<GetCommunityResponse> =
        client.postResult("community/transfer", form)

    /** @POST("community/ban_user") */
    override suspend fun banFromCommunity(form: BanFromCommunity): Result<PersonResponse> =
        client.postResult("community/ban_user", form)

    /** @POST("community/mod") */
    override suspend fun addModToCommunity(form: AddModToCommunity): Result<AddModToCommunityResponse> =
        client.postResult("community/mod", form)

    /** @GET("community/random") */
    override suspend fun getRandomCommunity(form: GetRandomCommunity): Result<CommunityResponse> =
        client.getResult("community/random", form)

    /** @POST("community/report") */
    override suspend fun createCommunityReport(form: CreateCommunityReport): Result<CommunityReportResponse> =
        client.postResult("community/report", form)

    /** @PUT("community/report/resolve") */
    override suspend fun resolveCommunityReport(form: ResolveCommunityReport): Result<CommunityReportResponse> =
        client.putResult("community/report/resolve", form)

    /** @POST("community/tag") */
    override suspend fun createCommunityTag(form: CreateCommunityTag): Result<CommunityTag> =
        client.postResult("community/tag", form)

    /** @PUT("community/tag") */
    override suspend fun editCommunityTag(form: EditCommunityTag): Result<CommunityTag> =
        client.putResult("community/tag", form)

    /** @DELETE("community/tag") */
    override suspend fun deleteCommunityTag(form: DeleteCommunityTag): Result<CommunityTag> =
        client.deleteResult("community/tag", form)

    /** @PUT("community/notifications") */
    override suspend fun editCommunityNotifications(form: EditCommunityNotifications): Result<Unit> =
        client.putResult("community/notifications", form)

    /** @POST("community/pending_follows/approve") */
    override suspend fun approveCommunityPendingFollow(form: ApproveCommunityPendingFollower): Result<Unit> =
        client.postResult("community/pending_follows/approve", form)

    /** @GET("community/pending_follows/list") */
    override suspend fun listCommunityPendingFollows(form: ListCommunityPendingFollows): Result<PagedResponse<PendingFollowerView>> =
        client.getResult("community/pending_follows/list", form)

    /** @DELETE("community/banner") */
    override suspend fun deleteCommunityBanner(form: CommunityIdQuery): Result<Unit> =
        client.deleteResult("community/banner", form)

    /** @DELETE("community/icon") */
    override suspend fun deleteCommunityIcon(form: CommunityIdQuery): Result<Unit> =
        client.deleteResult("community/icon", form)

    /** @GET("federated_instances") */
    override suspend fun getFederatedInstances(form: GetFederatedInstances): Result<PagedResponse<FederatedInstanceView>> =
        client.getResult("federated_instances", form)

    /** @GET("post") */
    override suspend fun getPost(form: GetPost): Result<GetPostResponse> =
        client.getResult("post", form)

    /** @POST("post") */
    override suspend fun createPost(form: CreatePost): Result<PostResponse> =
        client.postResult("post", form)

    /** @PUT("post") */
    override suspend fun editPost(form: EditPost): Result<PostResponse> =
        client.putResult("post", form)

    /** @DELETE("post") */
    override suspend fun deletePost(form: DeletePost): Result<PostResponse> =
        client.deleteResult("post", form)

    /** @GET("post/list") */
    override suspend fun getPosts(form: GetPosts): Result<PagedResponse<PostView>> =
        client.getResult("post/list", form)

    /** @POST("post/remove") */
    override suspend fun removePost(form: RemovePost): Result<PostResponse> =
        client.postResult("post/remove", form)

    /** @POST("post/mark_as_read") */
    override suspend fun markPostAsRead(form: MarkPostAsRead): Result<PostResponse> =
        client.postResult("post/mark_as_read", form)

    /** @POST("post/mark_as_read/many") */
    override suspend fun markManyPostsAsRead(form: MarkManyPostsAsRead): Result<Unit> =
        client.postResult("post/mark_as_read/many", form)

    /** @POST("post/lock") */
    override suspend fun lockPost(form: LockPost): Result<PostResponse> =
        client.postResult("post/lock", form)

    /** @POST("post/feature") */
    override suspend fun featurePost(form: FeaturePost): Result<PostResponse> =
        client.postResult("post/feature", form)

    /** @POST("post/like") */
    override suspend fun createPostLike(form: CreatePostLike): Result<PostResponse> =
        client.postResult("post/like", form)

    /** @PUT("post/save") */
    override suspend fun savePost(form: SavePost): Result<PostResponse> =
        client.putResult("post/save", form)

    /** @POST("post/report") */
    override suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse> =
        client.postResult("post/report", form)

    /** @PUT("post/report/resolve") */
    override suspend fun resolvePostReport(form: ResolvePostReport): Result<PostReportResponse> =
        client.putResult("post/report/resolve", form)

    /** @GET("post/site_metadata") */
    override suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse> =
        client.getResult("post/site_metadata", form)

    /** @POST("post/hide") */
    override suspend fun hidePost(form: HidePost): Result<PostResponse> =
        client.postResult("post/hide", form)

    /** @GET("post/like/list") */
    override suspend fun listPostLikes(form: ListPostLikes): Result<PagedResponse<VoteView>> =
        client.getResult("post/like/list", form)

    /** @PUT("post/mod_edit") */
    override suspend fun modEditPost(form: ModEditPost): Result<PostResponse> =
        client.putResult("post/mod_edit", form)

    /** @PUT("post/notifications") */
    override suspend fun editPostNotifications(form: EditPostNotifications): Result<Unit> =
        client.putResult("post/notifications", form)

    /** @POST("post/warn") */
    override suspend fun warnPost(form: CreatePostWarning): Result<PostResponse> =
        client.postResult("post/warn", form)

    /** @GET("comment") */
    override suspend fun getComment(form: GetComment): Result<CommentResponse> =
        client.getResult("comment", form)

    /** @POST("comment") */
    override suspend fun createComment(form: CreateComment): Result<CommentResponse> =
        client.postResult("comment", form)

    /** @PUT("comment") */
    override suspend fun editComment(form: EditComment): Result<CommentResponse> =
        client.putResult("comment", form)

    /** @DELETE("comment") */
    override suspend fun deleteComment(form: DeleteComment): Result<CommentResponse> =
        client.deleteResult("comment", form)

    /** @GET("comment/list") */
    override suspend fun getComments(form: GetComments): Result<PagedResponse<CommentView>> =
        client.getResult("comment/list", form)

    /** @GET("comment/list/slim") */
    override suspend fun getCommentsSlim(form: GetComments): Result<PagedResponse<CommentSlimView>> =
        client.getResult("comment/list/slim", form)

    /** @POST("comment/remove") */
    override suspend fun removeComment(form: RemoveComment): Result<CommentResponse> =
        client.postResult("comment/remove", form)

    /** @POST("comment/lock") */
    override suspend fun lockComment(form: LockComment): Result<CommentResponse> =
        client.postResult("comment/lock", form)

    /** @POST("comment/distinguish") */
    override suspend fun distinguishComment(form: DistinguishComment): Result<CommentResponse> =
        client.postResult("comment/distinguish", form)

    /** @POST("comment/like") */
    override suspend fun createCommentLike(form: CreateCommentLike): Result<CommentResponse> =
        client.postResult("comment/like", form)

    /** @PUT("comment/save") */
    override suspend fun saveComment(form: SaveComment): Result<CommentResponse> =
        client.putResult("comment/save", form)

    /** @POST("comment/report") */
    override suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse> =
        client.postResult("comment/report", form)

    /** @PUT("comment/report/resolve") */
    override suspend fun resolveCommentReport(form: ResolveCommentReport): Result<CommentReportResponse> =
        client.putResult("comment/report/resolve", form)

    /** @GET("comment/like/list") */
    override suspend fun listCommentLikes(form: ListCommentLikes): Result<PagedResponse<VoteView>> =
        client.getResult("comment/like/list", form)

    /** @POST("comment/warn") */
    override suspend fun warnComment(form: CreateCommentWarning): Result<CommentResponse> =
        client.postResult("comment/warn", form)

    /** @POST("private_message") */
    override suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse> =
        client.postResult("private_message", form)

    /** @PUT("private_message") */
    override suspend fun editPrivateMessage(form: EditPrivateMessage): Result<PrivateMessageResponse> =
        client.putResult("private_message", form)

    /** @DELETE("private_message") */
    override suspend fun deletePrivateMessage(form: DeletePrivateMessage): Result<PrivateMessageResponse> =
        client.deleteResult("private_message", form)

    /** @POST("private_message/report") */
    override suspend fun createPrivateMessageReport(form: CreatePrivateMessageReport): Result<PrivateMessageReportResponse> =
        client.postResult("private_message/report", form)

    /** @PUT("private_message/report/resolve") */
    override suspend fun resolvePrivateMessageReport(form: ResolvePrivateMessageReport): Result<PrivateMessageReportResponse> =
        client.putResult("private_message/report/resolve", form)

    /** @GET("person") */
    override suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse> =
        client.getResult("person", form)

    /** @GET("person/list") */
    override suspend fun listPersons(form: ListPersons): Result<PagedResponse<PersonView>> =
        client.getResult("person/list", form)

    /** @GET("person/content") */
    override suspend fun listPersonContent(form: ListPersonContent): Result<PagedResponse<PostCommentCombinedView>> =
        client.getResult("person/content", form)

    /** @POST("person/note") */
    override suspend fun notePerson(form: NotePerson): Result<Unit> =
        client.postResult("person/note", form)

    /** @GET("account") */
    override suspend fun getMyUser(): Result<MyUserInfo> =
        client.getResult("account")

    /** @DELETE("account") */
    override suspend fun deleteAccount(form: DeleteAccount): Result<Unit> =
        client.deleteResult("account", form)

    /** @POST("account/auth/login") */
    override suspend fun login(form: Login): Result<LoginResponse> =
        client.postResult("account/auth/login", form)

    /** @POST("account/auth/logout") */
    override suspend fun logout(): Result<Unit> =
        client.postResult("account/auth/logout")

    /** @POST("account/auth/register") */
    override suspend fun register(form: Register): Result<LoginResponse> =
        client.postResult("account/auth/register", form)

    /** @GET("account/auth/get_captcha") */
    override suspend fun getCaptcha(): Result<GetCaptchaResponse> =
        client.getResult("account/auth/get_captcha")

    /** @POST("account/auth/password_reset") */
    override suspend fun resetPassword(form: ResetPassword): Result<Unit> =
        client.postResult("account/auth/password_reset", form)

    /** @POST("account/auth/password_change") */
    override suspend fun changePasswordAfterReset(form: ChangePasswordAfterReset): Result<Unit> =
        client.postResult("account/auth/password_change", form)

    /** @PUT("account/auth/change_password") */
    override suspend fun changePassword(form: ChangePassword): Result<LoginResponse> =
        client.putResult("account/auth/change_password", form)

    /** @POST("account/auth/verify_email") */
    override suspend fun verifyEmail(form: VerifyEmail): Result<Unit> =
        client.postResult("account/auth/verify_email", form)

    /** @POST("account/auth/resend_verification_email") */
    override suspend fun resendVerificationEmail(form: ResendVerificationEmail): Result<Unit> =
        client.postResult("account/auth/resend_verification_email", form)

    /** @POST("account/auth/totp/generate") */
    override suspend fun generateTotpSecret(): Result<GenerateTotpSecretResponse> =
        client.postResult("account/auth/totp/generate")

    /** @POST("account/auth/totp/edit") */
    override suspend fun editTotp(form: EditTotp): Result<EditTotpResponse> =
        client.postResult("account/auth/totp/edit", form)

    /** @PUT("account/settings/save") */
    override suspend fun saveUserSettings(form: SaveUserSettings): Result<Unit> =
        client.putResult("account/settings/save", form)

    /** @GET("account/settings/export") */
    override suspend fun exportUserSettings(): Result<ExportUserSettingsResponse> =
        client.getResult("account/settings/export")

    /** @POST("account/settings/import") */
    override suspend fun importUserSettings(form: ImportUserSettings): Result<Unit> =
        client.postResult("account/settings/import", form)

    /** @POST("account/block/community") */
    override suspend fun blockCommunity(form: BlockCommunity): Result<CommunityResponse> =
        client.postResult("account/block/community", form)

    /** @POST("account/block/person") */
    override suspend fun blockPerson(form: BlockPerson): Result<PersonResponse> =
        client.postResult("account/block/person", form)

    /** @POST("account/block/instance/communities") */
    override suspend fun userBlockInstanceCommunities(form: UserBlockInstanceCommunitiesParams): Result<Unit> =
        client.postResult("account/block/instance/communities", form)

    /** @POST("account/block/instance/persons") */
    override suspend fun userBlockInstancePersons(form: UserBlockInstancePersonsParams): Result<Unit> =
        client.postResult("account/block/instance/persons", form)

    /** @POST("account/donation_dialog_shown") */
    override suspend fun markDonationDialogShown(): Result<Unit> =
        client.postResult("account/donation_dialog_shown")

    /** @GET("account/login/list") */
    override suspend fun listLogins(): Result<ListLoginsResponse> =
        client.getResult("account/login/list")

    /** @GET("account/validate_auth") */
    override suspend fun validateAuth(): Result<Unit> =
        client.getResult("account/validate_auth")

    /** @GET("account/unread_counts") */
    override suspend fun getUnreadCounts(): Result<UnreadCountsResponse> =
        client.getResult("account/unread_counts")

    /** @POST("account/notification/mark_as_read") */
    override suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit> =
        client.postResult("account/notification/mark_as_read", form)

    /** @POST("account/notification/mark_as_read/all") */
    override suspend fun markAllNotificationsAsRead(): Result<Unit> =
        client.postResult("account/notification/mark_as_read/all")

    /** @GET("account/notification/list") */
    override suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<NotificationView>> =
        client.getResult("account/notification/list", form)

    /** @GET("account/saved") */
    override suspend fun listPersonSaved(form: ListPersonSaved): Result<PagedResponse<PostCommentCombinedView>> =
        client.getResult("account/saved", form)

    /** @GET("account/read") */
    override suspend fun listPersonRead(form: ListPersonRead): Result<PagedResponse<PostView>> =
        client.getResult("account/read", form)

    /** @GET("account/hidden") */
    override suspend fun listPersonHidden(form: ListPersonHidden): Result<PagedResponse<PostView>> =
        client.getResult("account/hidden", form)

    /** @GET("account/liked") */
    override suspend fun listPersonLiked(form: ListPersonLiked): Result<PagedResponse<PostCommentCombinedView>> =
        client.getResult("account/liked", form)

    /** @GET("account/media/list") */
    override suspend fun listMedia(form: ListMedia): Result<PagedResponse<LocalImageView>> =
        client.getResult("account/media/list", form)

    /** @DELETE("account/media") */
    override suspend fun deleteMedia(form: DeleteImageParams): Result<Unit> =
        client.deleteResult("account/media", form)

    /** @DELETE("account/avatar") */
    override suspend fun deleteUserAvatar(): Result<Unit> =
        client.deleteResult("account/avatar")

    /** @DELETE("account/banner") */
    override suspend fun deleteUserBanner(): Result<Unit> =
        client.deleteResult("account/banner")

    /** @POST("admin/add") */
    override suspend fun addAdmin(form: AddAdmin): Result<AddAdminResponse> =
        client.postResult("admin/add", form)

    /** @POST("admin/ban") */
    override suspend fun banPerson(form: BanPerson): Result<PersonResponse> =
        client.postResult("admin/ban", form)

    /** @POST("admin/leave") */
    override suspend fun leaveAdmin(): Result<GetSiteResponse> =
        client.postResult("admin/leave")

    /** @GET("admin/registration_application") */
    override suspend fun getRegistrationApplication(form: GetRegistrationApplication): Result<RegistrationApplicationResponse> =
        client.getResult("admin/registration_application", form)

    /** @PUT("admin/registration_application/approve") */
    override suspend fun approveRegistrationApplication(form: ApproveRegistrationApplication): Result<RegistrationApplicationResponse> =
        client.putResult("admin/registration_application/approve", form)

    /** @GET("admin/registration_application/list") */
    override suspend fun listRegistrationApplications(form: ListRegistrationApplications): Result<PagedResponse<RegistrationApplicationView>> =
        client.getResult("admin/registration_application/list", form)

    /** @POST("admin/purge/person") */
    override suspend fun purgePerson(form: PurgePerson): Result<Unit> =
        client.postResult("admin/purge/person", form)

    /** @POST("admin/purge/community") */
    override suspend fun purgeCommunity(form: PurgeCommunity): Result<Unit> =
        client.postResult("admin/purge/community", form)

    /** @POST("admin/purge/post") */
    override suspend fun purgePost(form: PurgePost): Result<Unit> =
        client.postResult("admin/purge/post", form)

    /** @POST("admin/purge/comment") */
    override suspend fun purgeComment(form: PurgeComment): Result<Unit> =
        client.postResult("admin/purge/comment", form)

    /** @POST("admin/instance/block") */
    override suspend fun adminBlockInstance(form: AdminBlockInstanceParams): Result<Unit> =
        client.postResult("admin/instance/block", form)

    /** @POST("admin/instance/allow") */
    override suspend fun adminAllowInstance(form: AdminAllowInstanceParams): Result<Unit> =
        client.postResult("admin/instance/allow", form)

    /** @POST("admin/tagline") */
    override suspend fun createTagline(form: CreateTagline): Result<TaglineResponse> =
        client.postResult("admin/tagline", form)

    /** @PUT("admin/tagline") */
    override suspend fun editTagline(form: EditTagline): Result<TaglineResponse> =
        client.putResult("admin/tagline", form)

    /** @DELETE("admin/tagline") */
    override suspend fun deleteTagline(form: DeleteTagline): Result<Unit> =
        client.deleteResult("admin/tagline", form)

    /** @GET("admin/tagline/list") */
    override suspend fun listTaglines(form: ListTaglines): Result<PagedResponse<Tagline>> =
        client.getResult("admin/tagline/list", form)

    /** @GET("admin/users") */
    override suspend fun adminListUsers(form: AdminListUsers): Result<PagedResponse<LocalUserView>> =
        client.getResult("admin/users", form)

    /** @POST("custom_emoji") */
    override suspend fun createCustomEmoji(form: CreateCustomEmoji): Result<CustomEmojiResponse> =
        client.postResult("custom_emoji", form)

    /** @PUT("custom_emoji") */
    override suspend fun editCustomEmoji(form: EditCustomEmoji): Result<CustomEmojiResponse> =
        client.putResult("custom_emoji", form)

    /** @POST("custom_emoji/delete") */
    override suspend fun deleteCustomEmoji(form: DeleteCustomEmoji): Result<Unit> =
        client.postResult("custom_emoji/delete", form)

    /** @GET("custom_emoji/list") */
    override suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse> =
        client.getResult("custom_emoji/list", form)

    /** @POST("oauth/authenticate") */
    override suspend fun authenticateWithOAuth(form: AuthenticateWithOauth): Result<LoginResponse> =
        client.postResult("oauth/authenticate", form)

    /** @POST("oauth_provider") */
    override suspend fun createOAuthProvider(form: CreateOAuthProvider): Result<AdminOAuthProvider> =
        client.postResult("oauth_provider", form)

    /** @PUT("oauth_provider") */
    override suspend fun editOAuthProvider(form: EditOAuthProvider): Result<AdminOAuthProvider> =
        client.putResult("oauth_provider", form)

    /** @DELETE("oauth_provider") */
    override suspend fun deleteOAuthProvider(form: DeleteOAuthProvider): Result<Unit> =
        client.deleteResult("oauth_provider", form)

    /** @GET("report/list") */
    override suspend fun listReports(form: ListReports): Result<PagedResponse<ReportCombinedView>> =
        client.getResult("report/list", form)

    /** @GET("multi_community") */
    override suspend fun getMultiCommunity(form: GetMultiCommunity): Result<GetMultiCommunityResponse> =
        client.getResult("multi_community", form)

    /** @POST("multi_community") */
    override suspend fun createMultiCommunity(form: CreateMultiCommunity): Result<MultiCommunityResponse> =
        client.postResult("multi_community", form)

    /** @PUT("multi_community") */
    override suspend fun editMultiCommunity(form: EditMultiCommunity): Result<MultiCommunityResponse> =
        client.putResult("multi_community", form)

    /** @POST("multi_community/entry") */
    override suspend fun createMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<CommunityResponse> =
        client.postResult("multi_community/entry", form)

    /** @DELETE("multi_community/entry") */
    override suspend fun deleteMultiCommunityEntry(form: CreateOrDeleteMultiCommunityEntry): Result<Unit> =
        client.deleteResult("multi_community/entry", form)

    /** @POST("multi_community/follow") */
    override suspend fun followMultiCommunity(form: FollowMultiCommunity): Result<MultiCommunityResponse> =
        client.postResult("multi_community/follow", form)

    /** @GET("multi_community/list") */
    override suspend fun listMultiCommunities(form: ListMultiCommunities): Result<PagedResponse<MultiCommunityView>> =
        client.getResult("multi_community/list", form)

    /** @DELETE("image") */
    override suspend fun deleteMediaAdmin(form: DeleteImageParams): Result<Unit> =
        client.deleteResult("image", form)

    /** @GET("image/health") */
    override suspend fun imageHealth(): Result<Unit> =
        client.getResult("image/health")

    /** @GET("image/list") */
    override suspend fun listMediaAdmin(form: ListMedia): Result<PagedResponse<LocalImageView>> =
        client.getResult("image/list", form)

    /** @POST("community/banner") */
    override suspend fun uploadCommunityBanner(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse> =
        client.postUploadResult("community/banner", image) { addQueryParams(form) }

    /** @POST("community/icon") */
    override suspend fun uploadCommunityIcon(image: ByteArray, form: CommunityIdQuery): Result<UploadImageResponse> =
        client.postUploadResult("community/icon", image) { addQueryParams(form) }

    /** @POST("image") */
    override suspend fun uploadImage(image: ByteArray): Result<UploadImageResponse> =
        client.postUploadResult("image", image)

    /** @POST("site/banner") */
    override suspend fun uploadSiteBanner(image: ByteArray): Result<UploadImageResponse> =
        client.postUploadResult("site/banner", image)

    /** @POST("site/icon") */
    override suspend fun uploadSiteIcon(image: ByteArray): Result<UploadImageResponse> =
        client.postUploadResult("site/icon", image)

    /** @POST("account/avatar") */
    override suspend fun uploadUserAvatar(image: ByteArray): Result<UploadImageResponse> =
        client.postUploadResult("account/avatar", image)

    /** @POST("account/banner") */
    override suspend fun uploadUserBanner(image: ByteArray): Result<UploadImageResponse> =
        client.postUploadResult("account/banner", image)
}
