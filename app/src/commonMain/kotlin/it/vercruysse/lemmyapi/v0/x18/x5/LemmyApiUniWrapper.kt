package it.vercruysse.lemmyapi.v0.x18.x5

import io.github.z4kn4fein.semver.Version
import io.ktor.client.HttpClient
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.ListCustomEmojis
import it.vercruysse.lemmyapi.datatypes.ListCustomEmojisResponse
import it.vercruysse.lemmyapi.datatypes.ListNotifications
import it.vercruysse.lemmyapi.datatypes.MarkNotificationAsRead
import it.vercruysse.lemmyapi.datatypes.MyUserInfo
import it.vercruysse.lemmyapi.datatypes.PagedResponse
import it.vercruysse.lemmyapi.datatypes.UnreadCountsResponse
import it.vercruysse.lemmyapi.dto.ExportUserSettingsResponse
import it.vercruysse.lemmyapi.dto.ImportUserSettings
import it.vercruysse.lemmyapi.enums.NotificationDataType
import it.vercruysse.lemmyapi.enums.NotificationType
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetCaptcha
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonDetails
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetReportCount
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetUnreadCount
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetUnreadRegistrationApplicationCount
import it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkPostAsRead
import kotlin.map

internal class LemmyApiUniWrapper(client: HttpClient, actualVersion: Version, baseUrl: String, auth: String?) :
    LemmyApiBaseController(client, actualVersion, baseUrl, auth) {
    private val apiV18 = LemmyApiController(client, actualVersion, baseUrl, auth)
    private val transformer = Transformer(auth ?: "")

    override var auth: String? = auth
        set(value) {
            transformer.auth = value ?: ""
            field = value
            apiV18.auth = value // Not sure if this needed
        }

    // START

    /**
     * Gets the site, and your user data.
     *
     * @GET("site")
     */
    override suspend fun getSite(): Result<it.vercruysse.lemmyapi.datatypes.GetSiteResponse> = apiV18.getSite(
        it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSite(auth),
    ).map {
        transformer.toUni(it)
    }

    /**
     * Create your site.
     *
     * @POST("site")
     */
    override suspend fun createSite(
        form: it.vercruysse.lemmyapi.datatypes.CreateSite,
    ): Result<it.vercruysse.lemmyapi.datatypes.SiteResponse> = apiV18.createSite(transformer.fromUni(form)).map { transformer.toUni(it) }

    /**
     * Edit your site.
     *
     * @PUT("site")
     */
    override suspend fun editSite(form: it.vercruysse.lemmyapi.datatypes.EditSite): Result<it.vercruysse.lemmyapi.datatypes.SiteResponse> =
        apiV18.editSite(transformer.fromUni(form)).map { transformer.toUni(it) }

    /**
     * Get the modlog.
     *
     * @GET("modlog")
     */
    override suspend fun getModlog(
        form: it.vercruysse.lemmyapi.datatypes.GetModlog,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.ModlogView>> = notSupported()

    /**
     * Search lemmy.
     *
     * @GET("search")
     */
    override suspend fun search(form: it.vercruysse.lemmyapi.datatypes.Search): Result<it.vercruysse.lemmyapi.datatypes.SearchResponse> =
        apiV18.search(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Fetch a non-local / federated object.
     *
     * @GET("resolve_object")
     */
    override suspend fun resolveObject(
        form: it.vercruysse.lemmyapi.datatypes.ResolveObject,
    ): Result<it.vercruysse.lemmyapi.datatypes.SearchResponse> =
        apiV18.resolveObject(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Get / fetch a community.
     *
     * @GET("community")
     */
    override suspend fun getCommunity(
        form: it.vercruysse.lemmyapi.datatypes.GetCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.GetCommunityResponse> =
        apiV18.getCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Create a new community.
     *
     * @POST("community")
     */
    override suspend fun createCommunity(
        form: it.vercruysse.lemmyapi.datatypes.CreateCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.createCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Edit a community.
     *
     * @PUT("community")
     */
    override suspend fun editCommunity(
        form: it.vercruysse.lemmyapi.datatypes.EditCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.editCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Hide a community from public view.
     *
     * @PUT("community/hide")
     */
    override suspend fun hideCommunity(form: it.vercruysse.lemmyapi.datatypes.HideCommunity): Result<Unit> =
        apiV18.hideCommunity(transformer.fromUni(form))

    /**
     * List communities, with various filters.
     *
     * @GET("community/list")
     */
    override suspend fun listCommunities(
        form: it.vercruysse.lemmyapi.datatypes.ListCommunities,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.CommunityView>> =
        apiV18.listCommunities(transformer.fromUni(form)).map {
            PagedResponse(
                items = it.communities.map(transformer::toUni),
            )
        }

    /**
     * Follow / subscribe to a community.
     *
     * @POST("community/follow")
     */
    override suspend fun followCommunity(
        form: it.vercruysse.lemmyapi.datatypes.FollowCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.followCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Block a community.
     *
     * @POST("community/block")
     */
    override suspend fun blockCommunity(
        form: it.vercruysse.lemmyapi.datatypes.BlockCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.blockCommunity(transformer.fromUni(form)).map { resp ->
            it.vercruysse.lemmyapi.datatypes.CommunityResponse(
                transformer.toUni(resp.community_view),
                emptyList()
            )
        }

    /**
     * Delete a community.
     *
     * @POST("community/delete")
     */
    override suspend fun deleteCommunity(
        form: it.vercruysse.lemmyapi.datatypes.DeleteCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.deleteCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * A moderator remove for a community.
     *
     * @POST("community/remove")
     */
    override suspend fun removeCommunity(
        form: it.vercruysse.lemmyapi.datatypes.RemoveCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.removeCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Transfer your community to an existing moderator.
     *
     * @POST("community/transfer")
     */
    override suspend fun transferCommunity(
        form: it.vercruysse.lemmyapi.datatypes.TransferCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommunityResponse> =
        apiV18.transferCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Ban a user from a community.
     *
     * @POST("community/ban_user")
     */
    override suspend fun banFromCommunity(
        form: it.vercruysse.lemmyapi.datatypes.BanFromCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.PersonResponse> =
        apiV18.banFromCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Add a moderator to your community.
     *
     * @POST("community/mod")
     */
    override suspend fun addModToCommunity(
        form: it.vercruysse.lemmyapi.datatypes.AddModToCommunity,
    ): Result<it.vercruysse.lemmyapi.datatypes.AddModToCommunityResponse> =
        apiV18.addModToCommunity(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Fetch federated instances.
     *
     * @GET("federated_instances")
     */
    override suspend fun getFederatedInstances(form: it.vercruysse.lemmyapi.datatypes.GetFederatedInstances): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.FederatedInstanceView>> =
        notSupported() // Not used and complex to map

    /**
     * Get / fetch a post.
     *
     * @GET("post")
     */
    override suspend fun getPost(form: it.vercruysse.lemmyapi.datatypes.GetPost): Result<it.vercruysse.lemmyapi.datatypes.GetPostResponse> =
        apiV18.getPost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Edit a post.
     *
     * @PUT("post")
     */
    override suspend fun editPost(form: it.vercruysse.lemmyapi.datatypes.EditPost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.editPost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Create a post.
     *
     * @POST("post")
     */
    override suspend fun createPost(
        form: it.vercruysse.lemmyapi.datatypes.CreatePost,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.createPost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Get / fetch posts, with various filters.
     *
     * @GET("post/list")
     */
    override suspend fun getPosts(
        form: it.vercruysse.lemmyapi.datatypes.GetPosts,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostView>> =
        apiV18.getPosts(transformer.fromUni(form.toPostsForm())).map { resp ->
            PagedResponse(resp.posts.map(transformer::toUni))
        }

    /**
     * Delete a post.
     *
     * @POST("post/delete")
     */
    override suspend fun deletePost(
        form: it.vercruysse.lemmyapi.datatypes.DeletePost,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.deletePost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * A moderator remove for a post.
     *
     * @POST("post/remove")
     */
    override suspend fun removePost(
        form: it.vercruysse.lemmyapi.datatypes.RemovePost,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.removePost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Mark a post as read.
     *
     * @POST("post/mark_as_read")
     */
    override suspend fun markPostAsRead(form: it.vercruysse.lemmyapi.datatypes.MarkPostAsRead): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.markPostAsRead(
            MarkPostAsRead(
                post_id = form.post_id,
                read = form.read,
                auth = "" + auth,
            ),
        ).map(transformer::toUni)

    /**
     * Mark multiple posts as read.
     *
     * Maps v19 logic
     *
     * @POST("post/mark_as_read")
     */
    override suspend fun markManyPostsAsRead(form: it.vercruysse.lemmyapi.datatypes.MarkManyPostsAsRead): Result<Unit> = form.post_ids
        .map { MarkPostAsRead(post_id = it, read = form.read, auth = "" + auth) }
        .map { apiV18.markPostAsRead(it) }
        .map { it.map { } }
        .firstOrNull { it.isFailure } ?: Result.success(Unit)

    /**
     * A moderator can lock a post ( IE disable new comments ).
     *
     * @POST("post/lock")
     */
    override suspend fun lockPost(form: it.vercruysse.lemmyapi.datatypes.LockPost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.lockPost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * A moderator can feature a community post ( IE stick it to the top of a community ).
     *
     * @POST("post/feature")
     */
    override suspend fun featurePost(
        form: it.vercruysse.lemmyapi.datatypes.FeaturePost,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.featurePost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Like / vote on a post.
     *
     * @POST("post/like")
     */
    override suspend fun createPostLike(
        form: it.vercruysse.lemmyapi.datatypes.CreatePostLike,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.createPostLike(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Save a post.
     *
     * @PUT("post/save")
     */
    override suspend fun savePost(form: it.vercruysse.lemmyapi.datatypes.SavePost): Result<it.vercruysse.lemmyapi.datatypes.PostResponse> =
        apiV18.savePost(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Report a post.
     *
     * @POST("post/report")
     */
    override suspend fun createPostReport(
        form: it.vercruysse.lemmyapi.datatypes.CreatePostReport,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostReportResponse> =
        apiV18.createPostReport(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Resolve a post report. Only a mod can do this.
     *
     * @PUT("post/report/resolve")
     */
    override suspend fun resolvePostReport(
        form: it.vercruysse.lemmyapi.datatypes.ResolvePostReport,
    ): Result<it.vercruysse.lemmyapi.datatypes.PostReportResponse> =
        apiV18.resolvePostReport(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * List reports.
     */
    override suspend fun listReports(
        form: it.vercruysse.lemmyapi.datatypes.ListReports,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.ReportCombinedView>> =
        when (form.type_) {
            it.vercruysse.lemmyapi.enums.ReportType.Communities -> notSupported()
            it.vercruysse.lemmyapi.enums.ReportType.Posts -> {
                apiV18.listPostReports(transformer.fromUniP(form)).map { resp ->
                    PagedResponse(resp.post_reports.map(transformer::toUni))
                }
            }

            it.vercruysse.lemmyapi.enums.ReportType.Comments -> {
                apiV18.listCommentReports(transformer.fromUniC(form)).map { resp ->
                    PagedResponse(resp.comment_reports.map(transformer::toUni))
                }
            }

            it.vercruysse.lemmyapi.enums.ReportType.PrivateMessages -> {
                apiV18.listPrivateMessageReports(transformer.fromUniPm(form)).map { resp ->
                    PagedResponse(resp.private_message_reports.map(transformer::toUni))
                }
            }

            it.vercruysse.lemmyapi.enums.ReportType.All -> {
                runCatching {
                    val postsResp = apiV18.listPostReports(transformer.fromUniP(form)).getOrThrow()
                    val commentsResp = apiV18.listCommentReports(transformer.fromUniC(form)).getOrThrow()
                    val privateMessagesResp = apiV18.listPrivateMessageReports(transformer.fromUniPm(form)).getOrThrow()

                    val allReports = mutableListOf<it.vercruysse.lemmyapi.datatypes.ReportCombinedView>()

                    allReports.addAll(
                        postsResp.post_reports.map(transformer::toUni)
                    )

                    allReports.addAll(
                        commentsResp.comment_reports.map(transformer::toUni)
                    )

                    allReports.addAll(
                        privateMessagesResp.private_message_reports.map(transformer::toUni)
                    )

                    PagedResponse(allReports)
                }
            }
        }

    /**
     * Fetch metadata for any given site.
     *
     * @GET("post/site_metadata")
     */
    override suspend fun getSiteMetadata(
        form: it.vercruysse.lemmyapi.datatypes.GetSiteMetadata,
    ): Result<it.vercruysse.lemmyapi.datatypes.GetSiteMetadataResponse> =
        apiV18.getSiteMetadata(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Get / fetch comment.
     *
     * @GET("comment")
     */
    override suspend fun getComment(
        form: it.vercruysse.lemmyapi.datatypes.GetComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.getComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Create a comment.
     *
     * @POST("comment")
     */
    override suspend fun createComment(
        form: it.vercruysse.lemmyapi.datatypes.CreateComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.createComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Edit a comment.
     *
     * @PUT("comment")
     */
    override suspend fun editComment(
        form: it.vercruysse.lemmyapi.datatypes.EditComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.editComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Get / fetch comments.
     *
     * @GET("comment/list")
     */
    override suspend fun getComments(
        form: it.vercruysse.lemmyapi.datatypes.GetComments,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.CommentView>> =
        apiV18.getComments(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.comments.map(transformer::toUni))
        }

    /**
     * Delete a comment.
     *
     * @POST("comment/delete")
     */
    override suspend fun deleteComment(
        form: it.vercruysse.lemmyapi.datatypes.DeleteComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.deleteComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * A moderator remove for a comment.
     *
     * @POST("comment/remove")
     */
    override suspend fun removeComment(
        form: it.vercruysse.lemmyapi.datatypes.RemoveComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.removeComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Distinguishes a comment (speak as moderator)
     *
     * @POST("comment/distinguish")
     */
    override suspend fun distinguishComment(
        form: it.vercruysse.lemmyapi.datatypes.DistinguishComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.distinguishComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Like / vote on a comment.
     *
     * @POST("comment/like")
     */
    override suspend fun createCommentLike(
        form: it.vercruysse.lemmyapi.datatypes.CreateCommentLike,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.createCommentLike(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    override suspend fun saveComment(
        form: it.vercruysse.lemmyapi.datatypes.SaveComment,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentResponse> =
        apiV18.saveComment(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Report a comment.
     *
     * @POST("comment/report")
     */
    override suspend fun createCommentReport(
        form: it.vercruysse.lemmyapi.datatypes.CreateCommentReport,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentReportResponse> =
        apiV18.createCommentReport(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Resolve a comment report. Only a mod can do this.
     *
     * @PUT("comment/report/resolve")
     */
    override suspend fun resolveCommentReport(
        form: it.vercruysse.lemmyapi.datatypes.ResolveCommentReport,
    ): Result<it.vercruysse.lemmyapi.datatypes.CommentReportResponse> =
        apiV18.resolveCommentReport(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Edit a private message.
     *
     * @PUT("private_message")
     */
    override suspend fun editPrivateMessage(
        form: it.vercruysse.lemmyapi.datatypes.EditPrivateMessage,
    ): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse> =
        apiV18.editPrivateMessage(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    override suspend fun createPrivateMessage(
        form: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessage,
    ): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse> =
        apiV18.createPrivateMessage(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Delete a private message.
     *
     * @POST("private_message/delete")
     */
    override suspend fun deletePrivateMessage(
        form: it.vercruysse.lemmyapi.datatypes.DeletePrivateMessage,
    ): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageResponse> =
        apiV18.deletePrivateMessage(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Create a report for a private message.
     *
     * @POST("private_message/report")
     */
    override suspend fun createPrivateMessageReport(
        form: it.vercruysse.lemmyapi.datatypes.CreatePrivateMessageReport,
    ): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse> =
        apiV18.createPrivateMessageReport(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Resolve a report for a private message.
     *
     * @PUT("private_message/report/resolve")
     */
    override suspend fun resolvePrivateMessageReport(
        form: it.vercruysse.lemmyapi.datatypes.ResolvePrivateMessageReport,
    ): Result<it.vercruysse.lemmyapi.datatypes.PrivateMessageReportResponse> =
        apiV18.resolvePrivateMessageReport(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Get the details for a person.
     *
     * @GET("user")
     */
    override suspend fun getPersonDetails(
        form: it.vercruysse.lemmyapi.datatypes.GetPersonDetails,
    ): Result<it.vercruysse.lemmyapi.datatypes.GetPersonDetailsResponse> =
        apiV18.getPersonDetails(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Register a new user.
     *
     * @POST("user/register")
     */
    override suspend fun register(form: it.vercruysse.lemmyapi.datatypes.Register): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        apiV18.register(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Fetch a Captcha.
     *
     * @GET("user/get_captcha")
     */
    override suspend fun getCaptcha(): Result<it.vercruysse.lemmyapi.datatypes.GetCaptchaResponse> =
        apiV18.getCaptcha(GetCaptcha(auth)).map(transformer::toUni)

    /**
     * Mark a notification as read
     */
    override suspend fun markNotificationAsRead(form: MarkNotificationAsRead): Result<Unit> =
        when (form._kind) {
            NotificationType.Mention -> apiV18.markPersonMentionAsRead(transformer.fromUniM(form)).map { }
            NotificationType.Reply -> apiV18.markCommentReplyAsRead(transformer.fromUniR(form)).map { }
            NotificationType.PrivateMessage -> apiV18.markPrivateMessageAsRead(transformer.fromUniP(form)).map { }
            NotificationType.Subscribed, NotificationType.ModAction -> notSupported()
            null -> notSupported()
        }

    /**
     * List notifications.
     */
    override suspend fun listNotifications(form: ListNotifications): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.NotificationView>> = when (form.type_) {
        NotificationDataType.All ->
            runCatching {
                val replies = apiV18.getReplies(transformer.fromUniR(form)).getOrThrow().replies.map(transformer::toUni)
                val mentionReplies = apiV18.getPersonMentions(transformer.fromUniM(form)).getOrThrow().mentions.map(transformer::toUni)
                val privateMessages = apiV18.getPrivateMessages(transformer.fromUniP(form)).getOrThrow().private_messages.map(transformer::toUniPMV)

                PagedResponse(
                    buildList {
                        addAll(replies)
                        addAll(mentionReplies)
                        addAll(privateMessages)
                    },
                )
            }

        NotificationDataType.Reply ->
            apiV18.getReplies(transformer.fromUniR(form)).map { resp ->
                PagedResponse(resp.replies.map(transformer::toUni))
            }

        NotificationDataType.Mention ->
            apiV18.getPersonMentions(transformer.fromUniM(form)).map { resp ->
                PagedResponse(resp.mentions.map(transformer::toUni))
            }

        NotificationDataType.PrivateMessage ->
            apiV18.getPrivateMessages(transformer.fromUniP(form)).map { resp ->
                PagedResponse(resp.private_messages.map(transformer::toUniPMV))
            }

        NotificationDataType.Subscribed -> Result.success(PagedResponse(emptyList()))
    }

    /**
     * Ban a person from your site.
     *
     * @POST("user/ban")
     */
    override suspend fun banPerson(
        form: it.vercruysse.lemmyapi.datatypes.BanPerson,
    ): Result<it.vercruysse.lemmyapi.datatypes.PersonResponse> =
        apiV18.banPerson(transformer.fromUni(form)).map { resp ->
            it.vercruysse.lemmyapi.datatypes.PersonResponse(transformer.toUni(resp.person_view))
        }

    /**
     * Get a list of banned users
     *
     * @GET("user/banned")
     */
    override suspend fun getBannedPersons(): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PersonView>> =
        apiV18.getBannedPersons(it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetBannedPersons(auth ?: "")).map { resp ->
            PagedResponse(resp.banned.map(transformer::toUni))
        }

    /**
     * Block a person.
     *
     * @POST("user/block")
     */
    override suspend fun blockPerson(
        form: it.vercruysse.lemmyapi.datatypes.BlockPerson,
    ): Result<it.vercruysse.lemmyapi.datatypes.PersonResponse> =
        apiV18.blockPerson(transformer.fromUni(form)).map { resp ->
            it.vercruysse.lemmyapi.datatypes.PersonResponse(transformer.toUni(resp.person_view))
        }

    /**
     * Log into lemmy.
     *
     * @POST("user/login")
     */
    override suspend fun login(form: it.vercruysse.lemmyapi.datatypes.Login): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        apiV18.login(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Delete your account.
     *
     * @POST("user/delete_account")
     */
    override suspend fun deleteAccount(form: it.vercruysse.lemmyapi.datatypes.DeleteAccount): Result<Unit> =
        apiV18.deleteAccount(transformer.fromUni(form))

    /**
     * Reset your password.
     *
     * @POST("user/password_reset")
     */
    override suspend fun resetPassword(form: it.vercruysse.lemmyapi.datatypes.PasswordReset): Result<Unit> =
        apiV18.passwordReset(transformer.fromUni(form))

    /**
     * Change your password from an email / token based reset.
     *
     * @POST("user/password_change")
     */
    override suspend fun changePasswordAfterReset(form: it.vercruysse.lemmyapi.datatypes.PasswordChangeAfterReset): Result<Unit> =
        apiV18.passwordChangeAfterReset(transformer.fromUni(form))

    /**
     * Mark all replies as read.
     *
     * @POST("user/mark_all_as_read")
     */
    override suspend fun markAllNotificationsAsRead(): Result<Unit> =
        apiV18.markAllAsRead(it.vercruysse.lemmyapi.v0.x18.x5.datatypes.MarkAllAsRead(auth ?: "")).map {}

    /**
     * Save your user settings.
     *
     * @PUT("user/save_user_settings")
     */
    override suspend fun saveUserSettings(
        form: it.vercruysse.lemmyapi.datatypes.SaveUserSettings,
    ): Result<Unit> = apiV18.saveUserSettings(transformer.fromUni(form))

    /**
     * Change your user password.
     *
     * @PUT("user/change_password")
     */
    override suspend fun changePassword(
        form: it.vercruysse.lemmyapi.datatypes.ChangePassword,
    ): Result<it.vercruysse.lemmyapi.datatypes.LoginResponse> =
        apiV18.changePassword(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Get your unread counts
     *
     */
    override suspend fun getUnreadCounts(): Result<UnreadCountsResponse> = runCatching {
        val d = apiV18.getUnreadCount(GetUnreadCount(auth ?: "")).getOrThrow()
        val reportCount = apiV18.getReportCount(GetReportCount(null, auth ?: "")).getOrNull()
        val applicationCount = apiV18.getUnreadRegistrationApplicationCount(GetUnreadRegistrationApplicationCount(auth ?: "")).getOrNull()

        UnreadCountsResponse(
            notification_count = d.replies + d.mentions + d.private_messages,
            report_count = (reportCount?.post_reports ?: 0L) + (reportCount?.comment_reports ?: 0L) + (reportCount?.comment_reports ?: 0L),
            registration_application_count = applicationCount?.registration_applications,
        )
    }

    /**
     * Verify your email
     *
     * @POST("user/verify_email")
     */
    override suspend fun verifyEmail(form: it.vercruysse.lemmyapi.datatypes.VerifyEmail): Result<Unit> =
        apiV18.verifyEmail(transformer.fromUni(form))

    /**
     * Leave the Site admins.
     *
     * @POST("user/leave_admin")
     */
    override suspend fun leaveAdmin(): Result<it.vercruysse.lemmyapi.datatypes.GetSiteResponse> =
        apiV18.leaveAdmin(it.vercruysse.lemmyapi.v0.x18.x5.datatypes.LeaveAdmin(auth ?: "")).map(transformer::toUni)

    /**
     * Mark donation dialog as shown.
     *
     * @POST("user/donation_dialog_shown")
     */
    override suspend fun markDonationDialogShown(): Result<Unit> = notSupported()

    /**
     * Add an admin to your site.
     *
     * @POST("admin/add")
     */
    override suspend fun addAdmin(
        form: it.vercruysse.lemmyapi.datatypes.AddAdmin,
    ): Result<it.vercruysse.lemmyapi.datatypes.AddAdminResponse> =
        apiV18.addAdmin(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * List the registration applications.
     *
     * @GET("admin/registration_application/list")
     */
    override suspend fun listRegistrationApplications(
        form: it.vercruysse.lemmyapi.datatypes.ListRegistrationApplications,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.RegistrationApplicationView>> =
        apiV18.listRegistrationApplications(transformer.fromUni(form)).map { resp ->
            PagedResponse(resp.registration_applications.map(transformer::toUni))
        }

    /**
     * Approve a registration application
     *
     * @PUT("admin/registration_application/approve")
     */
    override suspend fun approveRegistrationApplication(
        form: it.vercruysse.lemmyapi.datatypes.ApproveRegistrationApplication,
    ): Result<it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse> =
        apiV18.approveRegistrationApplication(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Purge / Delete a person from the database.
     *
     * @POST("admin/purge/person")
     */
    override suspend fun purgePerson(form: it.vercruysse.lemmyapi.datatypes.PurgePerson): Result<Unit> =
        apiV18.purgePerson(transformer.fromUni(form))

    /**
     * Purge / Delete a community from the database.
     *
     * @POST("admin/purge/community")
     */
    override suspend fun purgeCommunity(form: it.vercruysse.lemmyapi.datatypes.PurgeCommunity): Result<Unit> =
        apiV18.purgeCommunity(transformer.fromUni(form))

    /**
     * Purge / Delete a post from the database.
     *
     * @POST("admin/purge/post")
     */
    override suspend fun purgePost(form: it.vercruysse.lemmyapi.datatypes.PurgePost): Result<Unit> =
        apiV18.purgePost(transformer.fromUni(form))

    /**
     * Purge / Delete a comment from the database.
     *
     * @POST("admin/purge/comment")
     */
    override suspend fun purgeComment(form: it.vercruysse.lemmyapi.datatypes.PurgeComment): Result<Unit> =
        apiV18.purgeComment(transformer.fromUni(form))

    /**
     * Edit an existing custom emoji
     *
     * @PUT("custom_emoji")
     */
    override suspend fun editCustomEmoji(
        form: it.vercruysse.lemmyapi.datatypes.EditCustomEmoji,
    ): Result<it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse> =
        apiV18.editCustomEmoji(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Create a new custom emoji
     *
     * @POST("custom_emoji")
     */
    override suspend fun createCustomEmoji(
        form: it.vercruysse.lemmyapi.datatypes.CreateCustomEmoji,
    ): Result<it.vercruysse.lemmyapi.datatypes.CustomEmojiResponse> =
        apiV18.createCustomEmoji(transformer.fromUni(form)).map(transformer::toUni)

    /**
     * Delete a custom emoji
     *
     * @POST("custom_emoji/delete")
     */
    override suspend fun deleteCustomEmoji(
        form: it.vercruysse.lemmyapi.datatypes.DeleteCustomEmoji,
    ): Result<Unit> = apiV18.deleteCustomEmoji(transformer.fromUni(form))

    /**
     * List custom emojis
     *
     * @GET("custom_emoji/list")
     */
    override suspend fun listCustomEmojis(form: ListCustomEmojis): Result<ListCustomEmojisResponse> =
        apiV18.getSite(it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSite(auth)).map {
            ListCustomEmojisResponse(it.custom_emojis.map(transformer::toUni))
        }

    /**
     * Block an instance.
     *
     * @POST("site/block")
     */
    override suspend fun blockInstance(
        form: it.vercruysse.lemmyapi.datatypes.UserBlockInstanceCommunitiesParams,
    ): Result<Unit> = notSupported()

    // possible supported by using old logic, but not be worth the effort

    /**
     * Generate a TOTP / two-factor secret.
     *
     * Afterwards you need to call `/user/totp/update` with a valid token to enable it.
     *
     * @POST("user/totp/generate")
     */
    override suspend fun generateTotpSecret(): Result<it.vercruysse.lemmyapi.datatypes.GenerateTotpSecretResponse> = notSupported()

    /**
     * Enable / Disable TOTP / two-factor authentication.
     *
     * To enable, you need to first call `/user/totp/generate` and then pass a valid token to this.
     *
     * Disabling is only possible if 2FA was previously enabled. Again it is necessary to pass a valid token.
     *
     * @POST("user/totp/update")
     */
    override suspend fun editTotp(
        form: it.vercruysse.lemmyapi.datatypes.EditTotp,
    ): Result<it.vercruysse.lemmyapi.datatypes.EditTotpResponse> = notSupported()

    /**
     * Export a backup of your user settings, including your saved content,
     * followed communities, and blocks.
     *
     * @GET("user/export_settings")
     */
    override suspend fun exportUserSettings(): Result<ExportUserSettingsResponse> = notSupported()

    /**
     * Import a backup of your user settings.
     *
     * @POST("user/import_settings")
     */
    override suspend fun importUserSettings(form: ImportUserSettings): Result<Unit> = notSupported()

    /**
     * List login tokens for your user
     *
     * @GET("user/list_logins")
     */
    override suspend fun listLogins(): Result<List<it.vercruysse.lemmyapi.datatypes.LoginToken>> = notSupported()

    /**
     * Returns an error message if your auth token is invalid
     *
     * @GET("user/validate_auth")
     */
    override suspend fun validateAuth(): Result<Unit> =
        // This request can only fail if the auth token is invalid
        apiV18.getPersonMentions(it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetPersonMentions(auth = auth ?: "")).map { }

    /**
     * Get data of current user
     *
     * @GET("/account")
     */
    override suspend fun getMyUser(): Result<MyUserInfo> =
        apiV18.getSite(it.vercruysse.lemmyapi.v0.x18.x5.datatypes.GetSite(auth))
            .mapCatching { it.my_user ?: throw IllegalStateException("Auth invalid") }
            .map { transformer.toUni(it) }

    /**
     * Logout your user
     *
     * @POST("user/logout")
     */
    override suspend fun logout(): Result<Unit> = notSupported()

    /**
     * List a post's likes. Admin-only.
     *
     * @GET("post/like/list")
     */
    override suspend fun listPostLikes(
        form: it.vercruysse.lemmyapi.datatypes.ListPostLikes,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.VoteView>> = notSupported()

    /**
     * List a comment's likes. Admin-only.
     *
     * @GET("comment/like/list")
     */
    override suspend fun listCommentLikes(
        form: it.vercruysse.lemmyapi.datatypes.ListCommentLikes,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.VoteView>> = notSupported()

    /**
     * List all the media for your user
     *
     * @GET("account/list_media")
     */
    override suspend fun listMedia(
        form: it.vercruysse.lemmyapi.datatypes.ListMedia,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalImageView>> = notSupported()

    /**
     * List all the media known to your instance.
     *
     * @GET("admin/list_all_media")
     */
    override suspend fun listAllMedia(
        form: it.vercruysse.lemmyapi.datatypes.ListMedia,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalImageView>> = notSupported()

    /**
     * Hide a post from list views.
     *
     * @POST("post/hide")
     */
    override suspend fun hidePost(form: it.vercruysse.lemmyapi.datatypes.HidePost): Result<Unit> = notSupported()

    /**
     * Get the application a user submitted when they first registered their account
     *
     * @GET("admin/registration_application")
     */
    override suspend fun getRegistrationApplication(
        form: it.vercruysse.lemmyapi.datatypes.GetRegistrationApplication,
    ): Result<it.vercruysse.lemmyapi.datatypes.RegistrationApplicationResponse> = notSupported()

    /**
     * List the content for a person.
     *
     * @GET("person/content")
     */
    override suspend fun listPersonContent(
        form: it.vercruysse.lemmyapi.datatypes.ListPersonContent,
    ): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.PostCommentCombinedView>> {
        val getPersonDetailsForm = GetPersonDetails(
            username = form.username,
            person_id = form.person_id,
            page = form.page,
            limit = form.limit,
            auth = auth,
        )
        return apiV18.getPersonDetails(getPersonDetailsForm).map { response ->
            val comments = when (form.type_) {
                it.vercruysse.lemmyapi.enums.PersonContentType.Posts -> emptyList()
                else -> response.comments.map { transformer.toUni(it) }
            }
            val posts = when (form.type_) {
                it.vercruysse.lemmyapi.enums.PersonContentType.Comments -> emptyList()
                else -> response.posts.map { transformer.toUni(it) }
            }
            PagedResponse(items = comments + posts)
        }
    }
    override suspend fun adminListUsers(form: it.vercruysse.lemmyapi.datatypes.AdminListUsers): Result<PagedResponse<it.vercruysse.lemmyapi.datatypes.LocalUserView>> = notSupported()
}
