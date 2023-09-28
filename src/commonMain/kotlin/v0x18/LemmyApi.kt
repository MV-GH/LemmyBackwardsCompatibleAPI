package v0x18

import LemmyApiBase
import v0x18.datatypes.*

interface LemmyApi : LemmyApiBase {

    override val version: String
        get() = "0.18"


    /**
     * Return site and user data.
     *
     * @GET("site")
     */
    suspend fun getSite(form: GetSite): Result<GetSiteResponse>

    /**
     * Get / fetch posts, with various filters.
     *
     *  @GET("post/list")
     */

    suspend fun getPosts(form: GetPosts): Result<GetPostsResponse>

    /**
     * Get / fetch a post.
     *
     *  @GET("post")
     */

    suspend fun getPost(form: GetPost): Result<GetPostResponse>

    /**
     * Log into lemmy.
     *
     *  @POST("user/login")
     */

    suspend fun login(form: Login): Result<LoginResponse>

    /**
     * Like / vote on a post.
     *
     *  @POST("post/like")
     */

    suspend fun likePost(form: CreatePostLike): Result<PostResponse>

    /**
     * Mark post as read.
     *
     * @POST("post/mark_as_read")
     */

    suspend fun markAsRead(form: MarkPostAsRead): Result<PostResponse>

    /**
     * Like / vote on a comment.
     *
     *  @POST("comment/like")
     */

    suspend fun likeComment(form: CreateCommentLike): Result<CommentResponse>

    /**
     * Create a comment.
     *
     *   @POST("comment")
     */

    suspend fun createComment(form: CreateComment): Result<CommentResponse>

    /**
     * Edit a comment.
     *
     *  @PUT("comment")
     */

    suspend fun editComment(form: EditComment): Result<CommentResponse>

    /**
     * Delete a comment.
     *
     *   @POST("comment/delete")
     */

    suspend fun deleteComment(form: DeleteComment): Result<CommentResponse>

    /**
     * Save a post.
     *
     *  @PUT("post/save")
     */

    suspend fun savePost(form: SavePost): Result<PostResponse>

    /**
     * Save a comment.
     *
     * @PUT("comment/save")
     */

    suspend fun saveComment(form: SaveComment): Result<CommentResponse>

    /**
     * Get / fetch comments.
     *
     *  @GET("comment/list")
     */

    suspend fun getComments(form: GetComments): Result<GetCommentsResponse>

    /**
     * Get / fetch a community.
     *
     *  @GET("community")
     */

    suspend fun getCommunity(form: GetCommunity): Result<GetCommunityResponse>

    /**
     * Get the details for a person.
     *
     *  @GET("user")
     */

    suspend fun getPersonDetails(form: GetPersonDetails): Result<GetPersonDetailsResponse>

    /**
     * Get comment replies.
     *
     *  @GET("user/replies")
     */

    suspend fun getReplies(form: GetReplies): Result<GetRepliesResponse>

    /**
     * Mark a comment as read.
     *
     *  @POST("comment/mark_as_read")
     */

    suspend fun markCommentReplyAsRead(form: MarkCommentReplyAsRead): Result<CommentReplyResponse>

    /**
     * Mark a person mention as read.
     *
     *   @POST("user/mention/mark_as_read")
     */

    suspend fun markPersonMentionAsRead(form: MarkPersonMentionAsRead): Result<PersonMentionResponse>

    /**
     * Mark a private message as read.
     *
     *  @POST("private_message/mark_as_read")
     */

    suspend fun markPrivateMessageAsRead(form: MarkPrivateMessageAsRead): Result<PrivateMessageResponse>

    /**
     * Mark all replies as read.
     *
     *  @POST("user/mark_all_as_read")
     */

    suspend fun markAllAsRead(form: MarkAllAsRead): Result<GetRepliesResponse>

    /**
     * Get mentions for your user.
     *
     *  @GET("user/mention")
     */

    suspend fun getPersonMentions(form: GetPersonMentions): Result<GetPersonMentionsResponse>

    /**
     * Get / fetch private messages.
     *
     *  @GET("private_message/list")
     */

    suspend fun getPrivateMessages(form: GetPrivateMessages): Result<PrivateMessagesResponse>

    /**
     * Create a private message.
     *
     * @POST("private_message")
     */

    suspend fun createPrivateMessage(form: CreatePrivateMessage): Result<PrivateMessageResponse>

    /**
     * Get your unread counts
     *
     *  @GET("user/unread_count")
     */

    suspend fun getUnreadCount(form: GetUnreadCount): Result<GetUnreadCountResponse>

    /**
     * Follow / subscribe to a community.
     *
     *  @POST("community/follow")
     */

    suspend fun followCommunity(form: FollowCommunity): Result<CommunityResponse>

    /**
     * Create a post.
     *
     *   @POST("post")
     */

    suspend fun createPost(form: CreatePost): Result<PostResponse>

    /**
     * Edit a post.
     *
     *   @PUT("post")
     */

    suspend fun editPost(form: EditPost): Result<PostResponse>

    /**
     * Delete a post.
     *
     *  @POST("post/delete")
     */

    suspend fun deletePost(form: DeletePost): Result<PostResponse>

    /**
     * Search lemmy.
     *
     *   @GET("search")
     */

    suspend fun search(form: Search): Result<SearchResponse>

    /**
     * Fetch metadata for any given site.
     *
     *   @GET("post/site_metadata")
     */

    suspend fun getSiteMetadata(form: GetSiteMetadata): Result<GetSiteMetadataResponse>

    /**
     * Report a comment.
     *
     *  @POST("comment/report")
     */

    suspend fun createCommentReport(form: CreateCommentReport): Result<CommentReportResponse>

    /**
     * Report a post.
     *
     *  @POST("post/report")
     */

    suspend fun createPostReport(form: CreatePostReport): Result<PostReportResponse>

    /**
     * Block a person.
     *
     *  @POST("user/block")
     */

    suspend fun blockPerson(form: BlockPerson): Result<BlockPersonResponse>

    /**
     * Block a community.
     *
     *  @POST("community/block")
     */

    suspend fun blockCommunity(form: BlockCommunity): Result<BlockCommunityResponse>

    /**
     * Save your user settings.
     *
     *   @PUT("user/save_user_settings")
     */

    suspend fun saveUserSettings(form: SaveUserSettings): Result<LoginResponse>
}