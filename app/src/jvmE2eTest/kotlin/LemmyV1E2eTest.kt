import it.vercruysse.lemmyapi.DatatypeRoot
import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.CommentView
import it.vercruysse.lemmyapi.datatypes.CreateComment
import it.vercruysse.lemmyapi.datatypes.CreateCommunity
import it.vercruysse.lemmyapi.datatypes.CreatePost
import it.vercruysse.lemmyapi.datatypes.PagedResponse
import it.vercruysse.lemmyapi.datatypes.PaginationCursor
import it.vercruysse.lemmyapi.datatypes.PostView
import java.util.concurrent.atomic.AtomicInteger

abstract class LemmyV1E2eTest {
    protected val anonApi: LemmyApiBaseController get() = env.anon
    protected val adminApi: LemmyApiBaseController get() = env.admin

    /** Regular (non admin) user that is shared by all tests, create a new one with [newUser] if you change its state. */
    protected val user: E2eUser get() = env.user

    protected val communityId: Long get() = env.communityId
    protected val postId: Long get() = env.postId
    protected val commentId: Long get() = env.commentId

    /** Seeded post/comment ids (the main seed entity first) all created by the admin. */
    protected val seededPostIds: List<Long> get() = env.seededPostIds
    protected val seededCommentIds: List<Long> get() = env.seededCommentIds

    protected suspend fun newUser(): E2eUser = env.newUser()

    protected suspend fun LemmyApiBaseController.newCommunity(): Long =
        createCommunity(CreateCommunity(name = unique("e2ec"), title = "E2E community"))
            .getOrThrow().community_view.community.id

    protected suspend fun LemmyApiBaseController.newPost(
        title: String = unique("E2E post"),
        body: String? = "E2E post body",
        inCommunity: Long = communityId,
    ): PostView =
        createPost(CreatePost(name = title, body = body, community_id = inCommunity)).getOrThrow().post_view

    protected suspend fun LemmyApiBaseController.newComment(
        content: String = unique("E2E comment"),
        onPost: Long = postId,
        parent: Long? = null,
    ): CommentView =
        createComment(CreateComment(content = content, post_id = onPost, parent_id = parent))
            .getOrThrow().comment_view

    /** Follows `next_page` until exhausted (or [maxPages]) and returns the items of each page. */
    protected suspend fun <T : DatatypeRoot> fetchPages(
        maxPages: Int = 20,
        fetch: suspend (PaginationCursor?) -> Result<PagedResponse<T>>,
    ): List<List<T>> {
        val pages = mutableListOf<List<T>>()
        var cursor: PaginationCursor? = null
        do {
            val page = fetch(cursor).getOrThrow()
            pages += page.items
            cursor = page.next_page
        } while (cursor != null && pages.size < maxPages)
        return pages
    }

    protected companion object {
        const val LEMMY_VERSION = LemmyV1E2eEnvironment.LEMMY_VERSION
        const val ADMIN_USERNAME = LemmyV1E2eEnvironment.ADMIN_USERNAME
        const val ADMIN_PASSWORD = LemmyV1E2eEnvironment.ADMIN_PASSWORD
        const val USER_PASSWORD = LemmyV1E2eEnvironment.USER_PASSWORD
        const val SEED_COMMUNITY_NAME = LemmyV1E2eEnvironment.SEED_COMMUNITY_NAME
        const val SEED_POST_TITLE = LemmyV1E2eEnvironment.SEED_POST_TITLE
        const val SEED_POST_BODY = LemmyV1E2eEnvironment.SEED_POST_BODY
        const val SEED_COMMENT_CONTENT = LemmyV1E2eEnvironment.SEED_COMMENT_CONTENT
        const val SEED_PAGING_COUNT = LemmyV1E2eEnvironment.SEED_PAGING_COUNT

        private val uniqueCounter = AtomicInteger()

        fun unique(prefix: String): String = "$prefix${uniqueCounter.incrementAndGet()}"

        private val env: LemmyV1E2eEnvironment by lazy {
            LemmyV1E2eEnvironment().also {
                Runtime.getRuntime().addShutdownHook(Thread { it.stop() })
                it.start()
            }
        }
    }
}
