package v0x18

import getKtor
import io.ktor.client.*
import utils.getResult
import utils.postResult
import utils.putResult
import v0x18.datatypes.*

class LemmyApiImpl(private val Ktor: HttpClient) : LemmyApi {

    override suspend fun getSite(form: GetSite): Result<GetSiteResponse> =
        Ktor.getResult("site", form)

    /**
     * Get / fetch posts, with various filters.
     *
     *  @GET("post/list")
     */
    override suspend fun getPosts(form: GetPosts): Result<GetPostsResponse> =
        Ktor.getResult("post/list", form)

    /**
     * Get / fetch a post.
     *
     *  @GET("post")
     */
    override suspend fun getPost(form: GetPost): Result<GetPostResponse> =
        Ktor.getResult("post", form)

    /**
     * Log into lemmy.
     *
     *  @POST("user/login")
     */
    override suspend fun login(form: Login): Result<LoginResponse> =
        Ktor.postResult("user/login", form)

    /**
     * Like / vote on a post.
     *
     *  @POST("post/like")
     */
    override suspend fun likePost(form: CreatePostLike): Result<PostResponse> =
        Ktor.postResult("post/like", form)

    /**
     * Mark post as read.
     *
     * @POST("post/mark_as_read")
     */
    override suspend fun markAsRead(form: MarkPostAsRead): Result<PostResponse> =
        Ktor.postResult("post/mark_as_read", form)


    /**
     * Like / vote on a comment.
     *
     *  @POST("comment/like")
     */
    override suspend fun likeComment(form: CreateCommentLike): Result<CommentResponse> =
        Ktor.postResult("comment/like", form)

    /**
     * Create a comment.
     *
     *   @POST("comment")
     */
    override suspend fun createComment(form: CreateComment): Result<CommentResponse> =
        Ktor.postResult("comment", form)

    /**
     * Edit a comment.
     *
     *  @PUT("comment")
     */
    override suspend fun editComment(form: EditComment): Result<CommentResponse> =
        Ktor.putResult("comment", form)

    /**
     * Delete a comment.
     *
     *   @POST("comment/delete")
     */
    override suspend fun deleteComment(form: DeleteComment): Result<CommentResponse> =
        Ktor.postResult("comment/delete", form)

    /**
     * Save a post.
     *
     *  @PUT("post/save")
     */
    override suspend fun savePost(form: SavePost): Result<PostResponse> =
        Ktor.putResult("post/save", form)

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */
    override suspend fun saveComment(form: SaveComment): Result<CommentResponse> =
        Ktor.putResult("comment/save", form)

    /**
     * Get / fetch comments.
     *
     *  @GET("comment/list")
     */
    override suspend fun getComments(form: GetComments): Result<GetCommentsResponse> =
        Ktor.getResult("comment/list", form)

    /**
     * Get / fetch a community.
     *
     *  @GET("community")
     */
    override suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse> =
        Ktor.getResult("community", form)

    /**
     * Get the details for a person.
     *
     *  @GET("user")
     */
    override suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse> =
        Ktor.getResult("user", form)

    /**
     * Get comment replies.
     *
     *  @GET("user/replies")
     */
    override suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse> =
        Ktor.getResult("user/replies", form)

    /**
     * Mark a comment as read.
     *
     *  @POST("comment/mark_as_read")
     */
    override suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse> =
        Ktor.postResult("comment/mark_as_read", form)

    /**
     * Mark a person mention as read.
     *
     *   @POST("user/mention/mark_as_read")
     */
    override suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse> =
        Ktor.postResult("user/mention/mark_as_read", form)

    /**
     * Mark a private message as read.
     *
     *  @POST("private_message/mark_as_read")
     */
    override suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse> =
        Ktor.postResult("private_message/mark_as_read", form)

    /**
     * Mark all replies as read.
     *
     *  @POST("user/mark_all_as_read")
     */
    override suspend fun markAllAsRead(form: MarkAllAsRead): Result<GetRepliesResponse> =
        Ktor.postResult("user/mark_all_as_read", form)

    /**
     * Get mentions for your user.
     *
     *  @GET("user/mention")
     */
    override suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse> =
        Ktor.getResult("user/mention", form)

    /**
     * Get / fetch private messages.
     *
     *  @GET("private_message/list")
     */
    override suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse> =
        Ktor.getResult("private_message/list", form)

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */
    override suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse> =
        Ktor.postResult("private_message", form)

    /**
     * Get your unread counts
     *
     *  @GET("user/unread_count")
     */
    override suspend fun getUnreadCount(form: GetUnreadCount): Result<GetUnreadCountResponse> =
        Ktor.getResult("user/unread_count", form)

    /**
     * Follow / subscribe to a community.
     *
     *  @POST("community/follow")
     */
    override suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse> =
        Ktor.postResult("community/follow", form)

    /**
     * Create a post.
     *
     *   @POST("post")
     */
    override suspend fun createPost(form: CreatePost): Result<PostResponse> =
        Ktor.postResult("post", form)

    /**
     * Edit a post.
     *
     *   @PUT("post")
     */
    override suspend fun editPost(form: EditPost): Result<PostResponse> =
        Ktor.putResult("post", form)

    /**
     * Delete a post.
     *
     *  @POST("post/delete")
     */
    override suspend fun deletePost(form: DeletePost): Result<PostResponse> =
        Ktor.postResult("post/delete", form)

    /**
     * Search lemmy.
     *
     *   @GET("search")
     */
    override suspend fun search(form: Search): Result<SearchResponse> =
        Ktor.getResult("search", form)

    /**
     * Fetch metadata for any given site.
     *
     *   @GET("post/site_metadata")
     */
    override suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse> =
        Ktor.getResult("post/site_metadata", form)

    /**
     * Report a comment.
     *
     *  @POST("comment/report")
     */
    override suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse> =
        Ktor.postResult("comment/report", form)

    /**
     * Report a post.
     *
     *  @POST("post/report")
     */
    override suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse> =
        Ktor.postResult("post/report", form)

    /**
     * Block a person.
     *
     *  @POST("user/block")
     */
    override suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse> =
        Ktor.postResult("user/block", form)

    /**
     * Block a community.
     *
     *  @POST("community/block")
     */
    override suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse> =
        Ktor.postResult("community/block", form)

    /**
     * Save your user settings.
     *
     *   @PUT("user/save_user_settings")
     */
    override suspend fun saveUserSettings(form: SaveUserSettings): Result<LoginResponse> =
        Ktor.putResult("user/save_user_settings", form)
}

suspend fun main() {
    val api = LemmyApiImpl(getKtor("https://lemmy.world/api/v3/"))

    println(api.version)
    //println(api.getSite(GetSite()))
    //println(api.login(Login("lemmy", "lemmy123")))
}