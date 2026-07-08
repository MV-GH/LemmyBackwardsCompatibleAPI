package it.vercruysse.lemmyapi.v1.x0.x0

import io.github.z4kn4fein.semver.Version
import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.ListCustomEmojis
import it.vercruysse.lemmyapi.datatypes.ListCustomEmojisResponse
import it.vercruysse.lemmyapi.datatypes.ListLoginsResponse
import it.vercruysse.lemmyapi.datatypes.ListNotifications
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.MyUserInfo
import it.vercruysse.lemmyapi.datatypes.PagedResponse
import it.vercruysse.lemmyapi.datatypes.UnreadCountsResponse
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings

internal class LemmyApiUniWrapper(client: HttpClient, actualVersion: Version, baseUrl: String, auth: String?) :
    LemmyApiBaseController(client, actualVersion, baseUrl, auth) {
    private val api = LemmyApiController(client, auth)
    private val transformer = Transformer()

    override var auth: String?
        get() = super.auth
        set(value) {
            super.auth = value
            api.auth = value
        }

    override suspend fun getSite(): Result<it.vercruysse.lemmyapi.datatypes.GetSiteResponse> =
        api.getSite().map(transformer::toUni)

    override suspend fun createSite(form: it.vercruysse.lemmyapi.datatypes.CreateSite): Result<it.vercruysse.lemmyapi.datatypes.SiteResponse> =
        api.createSite(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editSite(form: it.vercruysse.lemmyapi.datatypes.EditSite): Result<it.vercruysse.lemmyapi.datatypes.SiteResponse> =
        api.editSite(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getModlog(form: it.vercruysse.lemmyapi.datatypes.GetModlog): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.ModlogView>> =
        api.getModlog(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun search(form: it.vercruysse.lemmyapi.datatypes.Search): Result<it.vercruysse.lemmyapi.datatypes.SearchResponse> =
        api.search(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun resolveObject(form: it.vercruysse.lemmyapi.datatypes.ResolveObject): Result<it.vercruysse.lemmyapi.datatypes.SearchResponse> =
        api.resolveObject(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getCommunity(form: it.vercruysse.lemmyapi.datatypes.GetCommunity): Result<it.vercruysse.lemmyapi.datatypes.GetCommunityResponse> =
        api.getCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createCommunity(form: it.vercruysse.lemmyapi.datatypes.CreateCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.createCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editCommunity(form: it.vercruysse.lemmyapi.datatypes.EditCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.editCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun hideCommunity(form: it.vercruysse.lemmyapi.datatypes.HideCommunity): Result<Unit> =
        api.hideCommunity(transformer.fromUni(form))

    override suspend fun listCommunities(form: it.vercruysse.lemmyapi.datatypes.ListCommunities): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.CommunityView>> =
        api.listCommunities(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun followCommunity(form: it.vercruysse.lemmyapi.datatypes.FollowCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.followCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun blockCommunity(form: it.vercruysse.lemmyapi.datatypes.BlockCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.blockCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteCommunity(form: it.vercruysse.lemmyapi.datatypes.DeleteCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.deleteCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun removeCommunity(form: it.vercruysse.lemmyapi.datatypes.RemoveCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.removeCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun transferCommunity(form: it.vercruysse.lemmyapi.datatypes.TransferCommunity): Result<it.vercruysse.lemmyapi.datatypes.GetCommunityResponse> =
        api.transferCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun banFromCommunity(form: it.vercruysse.lemmyapi.datatypes.BanFromCommunity): Result<it.vercruysse.lemmyapi.datatypes.PersonResponse> =
        api.banFromCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun addModToCommunity(form: it.vercruysse.lemmyapi.datatypes.AddModToCommunity): Result<it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse> =
        api.addModToCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getFederatedInstances(form: it.vercruysse.lemmyapi.datatypes.GetFederatedInstances): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.FederatedInstanceView>> =
        api.getFederatedInstances(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun getPost(form: it.vercruysse.lemmyapi.datatypes.GetPost): Result<it.vercruysse.lemmyapi.datatypes.GetPostResponse> =
        api.getPost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editPost(form: it.vercruysse.lemmyapi.datatypes.EditPost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.editPost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createPost(form: it.vercruysse.lemmyapi.datatypes.CreatePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.createPost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getPosts(form: it.vercruysse.lemmyapi.datatypes.GetPosts): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostView>> =
        api.getPosts(transformer.fromUni(form.toValidatedForm())).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun deletePost(form: it.vercruysse.lemmyapi.datatypes.DeletePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.deletePost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun removePost(form: it.vercruysse.lemmyapi.datatypes.RemovePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.removePost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun markPostAsRead(form: it.vercruysse.lemmyapi.datatypes.MarkPostAsRead): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.markPostAsRead(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun markManyPostsAsRead(form: it.vercruysse.lemmyapi.datatypes.MarkManyPostsAsRead): Result<Unit> =
        api.markManyPostsAsRead(transformer.fromUni(form))

    override suspend fun lockPost(form: it.vercruysse.lemmyapi.datatypes.LockPost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.lockPost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun featurePost(form: it.vercruysse.lemmyapi.datatypes.FeaturePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.featurePost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createPostLike(form: it.vercruysse.lemmyapi.datatypes.CreatePostLike): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.createPostLike(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun savePost(form: it.vercruysse.lemmyapi.datatypes.SavePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.savePost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createPostReport(form: it.vercruysse.lemmyapi.datatypes.CreatePostReport): Result<it.vercruysse.lemmyapi.datatypes.PostReportResponse> =
        api.createPostReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun resolvePostReport(form: it.vercruysse.lemmyapi.datatypes.ResolvePostReport): Result<it.vercruysse.lemmyapi.datatypes.PostReportResponse> =
        api.resolvePostReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun listReports(form: it.vercruysse.lemmyapi.datatypes.ListReports): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.ReportCombinedView>> =
        api.listReports(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun getSiteMetadata(form: it.vercruysse.lemmyapi.datatypes.GetSiteMetadata): Result<it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse> =
        api.getSiteMetadata(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getComment(form: it.vercruysse.lemmyapi.datatypes.GetComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.getComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createComment(form: it.vercruysse.lemmyapi.datatypes.CreateComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.createComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editComment(form: it.vercruysse.lemmyapi.datatypes.EditComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.editComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getComments(form: it.vercruysse.lemmyapi.datatypes.GetComments): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.CommentView>> =
        api.getComments(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun deleteComment(form: it.vercruysse.lemmyapi.datatypes.DeleteComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.deleteComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun removeComment(form: it.vercruysse.lemmyapi.datatypes.RemoveComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.removeComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun distinguishComment(form: it.vercruysse.lemmyapi.datatypes.DistinguishComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.distinguishComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createCommentLike(form: it.vercruysse.lemmyapi.datatypes.CreateCommentLike): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.createCommentLike(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun saveComment(form: it.vercruysse.lemmyapi.datatypes.SaveComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.saveComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createCommentReport(form: it.vercruysse.lemmyapi.datatypes.CreateCommentReport): Result<it.vercruysse.lemmyapi.datatypes.CommentReportResponse> =
        api.createCommentReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun resolveCommentReport(form: it.vercruysse.lemmyapi.datatypes.ResolveCommentReport): Result<it.vercruysse.lemmyapi.datatypes.CommentReportResponse> =
        api.resolveCommentReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editPrivateMessage(form: it.vercruysse.lemmyapi.datatypes.EditPrivateMessage): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse> =
        api.editPrivateMessage(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createPrivateMessage(form: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse> =
        api.createPrivateMessage(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deletePrivateMessage(form: it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse> =
        api.deletePrivateMessage(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createPrivateMessageReport(form: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse> =
        api.createPrivateMessageReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun resolvePrivateMessageReport(form: it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse> =
        api.resolvePrivateMessageReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getPersonDetails(form: it.vercruysse.lemmyapi.datatypes.GetPersonDetails): Result<it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse> =
        api.getPersonDetails(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun listPersons(form: it.vercruysse.lemmyapi.datatypes.ListPersons): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PersonView>> =
        api.listPersons(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun register(form: it.vercruysse.lemmyapi.datatypes.Register): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        api.register(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getCaptcha(): Result<it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse> =
        api.getCaptcha().map(transformer::toUni)

    override suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit> =
        api.markNotificationAsRead(transformer.fromUni(form))

    override suspend fun markAllNotificationsAsRead(): Result<Unit> =
        api.markAllNotificationsAsRead()

    override suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.NotificationView>> =
        api.listNotifications(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun banPerson(form: it.vercruysse.lemmyapi.datatypes.BanPerson): Result<it.vercruysse.lemmyapi.datatypes.PersonResponse> =
        api.banPerson(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getBannedPersons(): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PersonView>> =
        notSupported()

    override suspend fun blockPerson(form: it.vercruysse.lemmyapi.datatypes.BlockPerson): Result<it.vercruysse.lemmyapi.datatypes.PersonResponse> =
        api.blockPerson(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun login(form: it.vercruysse.lemmyapi.datatypes.Login): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        api.login(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteAccount(form: it.vercruysse.lemmyapi.datatypes.DeleteAccount): Result<Unit> =
        api.deleteAccount(transformer.fromUni(form))

    override suspend fun resetPassword(form: it.vercruysse.lemmyapi.datatypes.ResetPassword): Result<Unit> =
        api.resetPassword(transformer.fromUni(form))

    override suspend fun changePasswordAfterReset(form: it.vercruysse.lemmyapi.datatypes.ChangePasswordAfterReset): Result<Unit> =
        api.changePasswordAfterReset(transformer.fromUni(form))

    override suspend fun saveUserSettings(form: it.vercruysse.lemmyapi.datatypes.SaveUserSettings): Result<Unit> =
        api.saveUserSettings(transformer.fromUni(form))

    override suspend fun changePassword(form: it.vercruysse.lemmyapi.datatypes.ChangePassword): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        api.changePassword(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getUnreadCounts(): Result<UnreadCountsResponse> =
        api.getUnreadCounts().map(transformer::toUni)

    override suspend fun verifyEmail(form: it.vercruysse.lemmyapi.datatypes.VerifyEmail): Result<Unit> =
        api.verifyEmail(transformer.fromUni(form))

    override suspend fun leaveAdmin(): Result<it.vercruysse.lemmyapi.datatypes.GetSiteResponse> =
        api.leaveAdmin().map(transformer::toUni)

    override suspend fun markDonationDialogShown(): Result<Unit> =
        api.markDonationDialogShown()

    override suspend fun addAdmin(form: it.vercruysse.lemmyapi.datatypes.AddAdmin): Result<it.vercruysse.lemmyapi.datatypes.AddAdminResponse> =
        api.addAdmin(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun listRegistrationApplications(form: it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView>> =
        api.listRegistrationApplications(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun approveRegistrationApplication(form: it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication): Result<it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse> =
        api.approveRegistrationApplication(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun purgePerson(form: it.vercruysse.lemmyapi.datatypes.PurgePerson): Result<Unit> =
        api.purgePerson(transformer.fromUni(form))

    override suspend fun purgeCommunity(form: it.vercruysse.lemmyapi.datatypes.PurgeCommunity): Result<Unit> =
        api.purgeCommunity(transformer.fromUni(form))

    override suspend fun purgePost(form: it.vercruysse.lemmyapi.datatypes.PurgePost): Result<Unit> =
        api.purgePost(transformer.fromUni(form))

    override suspend fun purgeComment(form: it.vercruysse.lemmyapi.datatypes.PurgeComment): Result<Unit> =
        api.purgeComment(transformer.fromUni(form))

    override suspend fun editCustomEmoji(form: it.vercruysse.lemmyapi.datatypes.EditCustomEmoji): Result<it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse> =
        api.editCustomEmoji(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createCustomEmoji(form: it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji): Result<it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse> =
        api.createCustomEmoji(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteCustomEmoji(form: it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji): Result<Unit> =
        api.deleteCustomEmoji(transformer.fromUni(form))

    override suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse> =
        api.listCustomEmojis(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun userBlockInstanceCommunities(form: it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams): Result<Unit> =
        api.userBlockInstanceCommunities(transformer.fromUni(form))

    override suspend fun generateTotpSecret(): Result<it.vercruysse.lemmyapi.datatypes.GenerateTotpSecretResponse> =
        api.generateTotpSecret().map(transformer::toUni)

    override suspend fun editTotp(form: it.vercruysse.lemmyapi.datatypes.EditTotp): Result<it.vercruysse.lemmyapi.datatypes.EditTotpResponse> =
        api.editTotp(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun exportUserSettings(): Result<ExportUserSettingsResponse> =
        api.exportUserSettings()

    override suspend fun importUserSettings(form: ImportUserSettings): Result<Unit> =
        api.importUserSettings(form)

    override suspend fun listLogins(): Result<ListLoginsResponse> =
        api.listLogins().map(transformer::toUni)

    override suspend fun validateAuth(): Result<Unit> =
        api.validateAuth()

    override suspend fun getMyUser(): Result<MyUserInfo> =
        api.getMyUser().map(transformer::toUni)

    override suspend fun logout(): Result<Unit> =
        api.logout()

    override suspend fun listPostLikes(form: it.vercruysse.lemmyapi.datatypes.ListPostLikes): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.VoteView>> =
        api.listPostLikes(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun listCommentLikes(form: it.vercruysse.lemmyapi.datatypes.ListCommentLikes): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.VoteView>> =
        api.listCommentLikes(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun createRegistrationInvitation(form: it.vercruysse.lemmyapi.datatypes.CreateInvitation): Result<it.vercruysse.lemmyapi.datatypes.CreateInvitationResponse> =
        api.createRegistrationInvitation(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun revokeRegistrationInvitation(form: it.vercruysse.lemmyapi.datatypes.RevokeInvitation): Result<Unit> =
        api.revokeRegistrationInvitation(transformer.fromUni(form))

    override suspend fun listRegistrationInvitations(form: it.vercruysse.lemmyapi.datatypes.ListInvitations): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalUserInvite>> =
        api.listRegistrationInvitations(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun listMedia(form: it.vercruysse.lemmyapi.datatypes.ListMedia): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalImageView>> =
        api.listMedia(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun listMediaAdmin(form: it.vercruysse.lemmyapi.datatypes.ListMedia): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalImageView>> =
        api.listMediaAdmin(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun hidePost(form: it.vercruysse.lemmyapi.datatypes.HidePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.hidePost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun hidePosts(form: it.vercruysse.lemmyapi.datatypes.HidePosts): Result<Unit> = notSupported()

    override suspend fun getRegistrationApplication(form: it.vercruysse.lemmyapi.datatypes.GetRegistrationApplication): Result<it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse> =
        api.getRegistrationApplication(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun listPersonContent(form: it.vercruysse.lemmyapi.datatypes.ListPersonContent): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostCommentCombinedView>> =
        api.listPersonContent(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun uploadImage(image: ByteArray): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadImage(image).map(transformer::toUni)

    override suspend fun uploadCommunityBanner(image: ByteArray, form: it.vercruysse.lemmyapi.datatypes.CommunityIdQuery): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadCommunityBanner(image, transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun uploadCommunityIcon(image: ByteArray, form: it.vercruysse.lemmyapi.datatypes.CommunityIdQuery): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadCommunityIcon(image, transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun uploadSiteBanner(image: ByteArray): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadSiteBanner(image).map(transformer::toUni)

    override suspend fun uploadSiteIcon(image: ByteArray): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadSiteIcon(image).map(transformer::toUni)

    override suspend fun uploadUserAvatar(image: ByteArray): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadUserAvatar(image).map(transformer::toUni)

    override suspend fun uploadUserBanner(image: ByteArray): Result<it.vercruysse.lemmyapi.datatypes.UploadImageResponse> =
        api.uploadUserBanner(image).map(transformer::toUni)

    override suspend fun deleteUserAvatar(): Result<Unit> =
        api.deleteUserAvatar()

    override suspend fun deleteUserBanner(): Result<Unit> =
        api.deleteUserBanner()

    override suspend fun deleteCommunityBanner(form: it.vercruysse.lemmyapi.datatypes.CommunityIdQuery): Result<Unit> =
        api.deleteCommunityBanner(transformer.fromUni(form))

    override suspend fun deleteCommunityIcon(form: it.vercruysse.lemmyapi.datatypes.CommunityIdQuery): Result<Unit> =
        api.deleteCommunityIcon(transformer.fromUni(form))

    override suspend fun deleteSiteBanner(): Result<Unit> =
        api.deleteSiteBanner()

    override suspend fun deleteSiteIcon(): Result<Unit> =
        api.deleteSiteIcon()

    override suspend fun deleteMedia(form: it.vercruysse.lemmyapi.datatypes.DeleteImageParams): Result<Unit> =
        api.deleteMedia(transformer.fromUni(form))

    override suspend fun deleteMediaAdmin(form: it.vercruysse.lemmyapi.datatypes.DeleteImageParams): Result<Unit> =
        api.deleteMediaAdmin(transformer.fromUni(form))

    override suspend fun imageHealth(): Result<Unit> =
        api.imageHealth()

    override suspend fun adminListUsers(form: it.vercruysse.lemmyapi.datatypes.AdminListUsers): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalUserView>> =
        api.adminListUsers(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun getRandomCommunity(form: it.vercruysse.lemmyapi.datatypes.GetRandomCommunity): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.getRandomCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createCommunityReport(form: it.vercruysse.lemmyapi.datatypes.CreateCommunityReport): Result<it.vercruysse.lemmyapi.datatypes.CommunityReportResponse> =
        api.createCommunityReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun resolveCommunityReport(form: it.vercruysse.lemmyapi.datatypes.ResolveCommunityReport): Result<it.vercruysse.lemmyapi.datatypes.CommunityReportResponse> =
        api.resolveCommunityReport(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createCommunityTag(form: it.vercruysse.lemmyapi.datatypes.CreateCommunityTag): Result<it.vercruysse.lemmyapi.datatypes.CommunityTag> =
        api.createCommunityTag(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editCommunityTag(form: it.vercruysse.lemmyapi.datatypes.EditCommunityTag): Result<it.vercruysse.lemmyapi.datatypes.CommunityTag> =
        api.editCommunityTag(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteCommunityTag(form: it.vercruysse.lemmyapi.datatypes.DeleteCommunityTag): Result<it.vercruysse.lemmyapi.datatypes.CommunityTag> =
        api.deleteCommunityTag(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editCommunityNotifications(form: it.vercruysse.lemmyapi.datatypes.EditCommunityNotifications): Result<Unit> =
        api.editCommunityNotifications(transformer.fromUni(form))

    override suspend fun approveCommunityPendingFollow(form: it.vercruysse.lemmyapi.datatypes.ApproveCommunityPendingFollower): Result<Unit> =
        api.approveCommunityPendingFollow(transformer.fromUni(form))

    override suspend fun listCommunityPendingFollows(form: it.vercruysse.lemmyapi.datatypes.ListCommunityPendingFollows): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PendingFollowerView>> =
        api.listCommunityPendingFollows(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun modEditPost(form: it.vercruysse.lemmyapi.datatypes.ModEditPost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.modEditPost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editPostNotifications(form: it.vercruysse.lemmyapi.datatypes.EditPostNotifications): Result<Unit> =
        api.editPostNotifications(transformer.fromUni(form))

    override suspend fun warnPost(form: it.vercruysse.lemmyapi.datatypes.CreatePostWarning): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        api.warnPost(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun getCommentsSlim(form: it.vercruysse.lemmyapi.datatypes.GetComments): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.CommentSlimView>> =
        api.getCommentsSlim(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun lockComment(form: it.vercruysse.lemmyapi.datatypes.LockComment): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.lockComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun warnComment(form: it.vercruysse.lemmyapi.datatypes.CreateCommentWarning): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        api.warnComment(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun notePerson(form: it.vercruysse.lemmyapi.datatypes.NotePerson): Result<Unit> =
        api.notePerson(transformer.fromUni(form))

    override suspend fun listPersonSaved(form: it.vercruysse.lemmyapi.datatypes.ListPersonSaved): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostCommentCombinedView>> =
        api.listPersonSaved(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun listPersonRead(form: it.vercruysse.lemmyapi.datatypes.ListPersonRead): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostView>> =
        api.listPersonRead(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun listPersonHidden(form: it.vercruysse.lemmyapi.datatypes.ListPersonHidden): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostView>> =
        api.listPersonHidden(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun listPersonLiked(form: it.vercruysse.lemmyapi.datatypes.ListPersonLiked): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostCommentCombinedView>> =
        api.listPersonLiked(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun resendVerificationEmail(form: it.vercruysse.lemmyapi.datatypes.ResendVerificationEmail): Result<Unit> =
        api.resendVerificationEmail(transformer.fromUni(form))

    override suspend fun authenticateWithOAuth(form: it.vercruysse.lemmyapi.datatypes.AuthenticateWithOauth): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        api.authenticateWithOAuth(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun userBlockInstancePersons(form: it.vercruysse.lemmyapi.datatypes.UserBlockInstancePersonsParams): Result<Unit> =
        api.userBlockInstancePersons(transformer.fromUni(form))

    override suspend fun adminAllowInstance(form: it.vercruysse.lemmyapi.datatypes.AdminAllowInstanceParams): Result<Unit> =
        api.adminAllowInstance(transformer.fromUni(form))

    override suspend fun adminBlockInstance(form: it.vercruysse.lemmyapi.datatypes.AdminBlockInstanceParams): Result<Unit> =
        api.adminBlockInstance(transformer.fromUni(form))

    override suspend fun createTagline(form: it.vercruysse.lemmyapi.datatypes.CreateTagline): Result<it.vercruysse.lemmyapi.datatypes.TaglineResponse> =
        api.createTagline(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editTagline(form: it.vercruysse.lemmyapi.datatypes.EditTagline): Result<it.vercruysse.lemmyapi.datatypes.TaglineResponse> =
        api.editTagline(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteTagline(form: it.vercruysse.lemmyapi.datatypes.DeleteTagline): Result<Unit> =
        api.deleteTagline(transformer.fromUni(form))

    override suspend fun listTaglines(form: it.vercruysse.lemmyapi.datatypes.ListTaglines): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.Tagline>> =
        api.listTaglines(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }

    override suspend fun createOAuthProvider(form: it.vercruysse.lemmyapi.datatypes.CreateOAuthProvider): Result<it.vercruysse.lemmyapi.datatypes.AdminOAuthProvider> =
        api.createOAuthProvider(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editOAuthProvider(form: it.vercruysse.lemmyapi.datatypes.EditOAuthProvider): Result<it.vercruysse.lemmyapi.datatypes.AdminOAuthProvider> =
        api.editOAuthProvider(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteOAuthProvider(form: it.vercruysse.lemmyapi.datatypes.DeleteOAuthProvider): Result<Unit> =
        api.deleteOAuthProvider(transformer.fromUni(form))

    override suspend fun getMultiCommunity(form: it.vercruysse.lemmyapi.datatypes.GetMultiCommunity): Result<it.vercruysse.lemmyapi.datatypes.GetMultiCommunityResponse> =
        api.getMultiCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createMultiCommunity(form: it.vercruysse.lemmyapi.datatypes.CreateMultiCommunity): Result<it.vercruysse.lemmyapi.datatypes.MultiCommunityResponse> =
        api.createMultiCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun editMultiCommunity(form: it.vercruysse.lemmyapi.datatypes.EditMultiCommunity): Result<it.vercruysse.lemmyapi.datatypes.MultiCommunityResponse> =
        api.editMultiCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun createMultiCommunityEntry(form: it.vercruysse.lemmyapi.datatypes.CreateOrDeleteMultiCommunityEntry): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        api.createMultiCommunityEntry(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun deleteMultiCommunityEntry(form: it.vercruysse.lemmyapi.datatypes.CreateOrDeleteMultiCommunityEntry): Result<Unit> =
        api.deleteMultiCommunityEntry(transformer.fromUni(form))

    override suspend fun followMultiCommunity(form: it.vercruysse.lemmyapi.datatypes.FollowMultiCommunity): Result<it.vercruysse.lemmyapi.datatypes.MultiCommunityResponse> =
        api.followMultiCommunity(transformer.fromUni(form)).map(transformer::toUni)

    override suspend fun listMultiCommunities(form: it.vercruysse.lemmyapi.datatypes.ListMultiCommunities): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.MultiCommunityView>> =
        api.listMultiCommunities(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.items.map(transformer::toUni))
        }
}
