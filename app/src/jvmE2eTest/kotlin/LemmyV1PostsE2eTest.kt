import it.vercruysse.lemmyapi.datatypes.CreatePostLike
import it.vercruysse.lemmyapi.datatypes.CreatePostReport
import it.vercruysse.lemmyapi.datatypes.DeletePost
import it.vercruysse.lemmyapi.datatypes.EditPost
import it.vercruysse.lemmyapi.datatypes.FollowCommunity
import it.vercruysse.lemmyapi.datatypes.GetPost
import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.datatypes.HidePost
import it.vercruysse.lemmyapi.datatypes.ListReports
import it.vercruysse.lemmyapi.datatypes.MarkPostAsRead
import it.vercruysse.lemmyapi.datatypes.PostReportView
import it.vercruysse.lemmyapi.datatypes.SavePost
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.ReportType
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LemmyV1PostsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous post list returns the seeded post`() =
        runBlocking {
            val response = anonApi.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME)).getOrThrow()
            val post = response.items.single { it.post.id == postId }

            assertEquals(SEED_POST_TITLE, post.post.name)
            assertEquals(SEED_POST_BODY, post.post.body)
            assertEquals(ADMIN_USERNAME, post.creator.name)
            assertEquals(SEED_COMMUNITY_NAME, post.community.name)
            assertTrue(post.post.published_at.isNotBlank())
            assertNull(post.post_actions)
        }

    @Test
    fun `anonymous post list can be paged`() =
        runBlocking {
            val pages =
                fetchPages { cursor ->
                    anonApi.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, limit = 2, page_cursor = cursor))
                }
            val ids = pages.flatten().map { it.post.id }

            assertTrue(pages.size >= 3, "Expected multiple pages but got ${pages.size}")
            assertEquals(2, pages.first().size)
            assertEquals(ids.distinct(), ids, "Pages must not repeat posts")
            assertTrue(ids.containsAll(seededPostIds))
        }

    @Test
    fun `post list sort order is respected`() =
        runBlocking {
            val newest = anonApi.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, sort = SortType.New)).getOrThrow()
            val oldest = anonApi.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, sort = SortType.Old)).getOrThrow()

            assertEquals(oldest.items.map { it.post.id }.sorted(), oldest.items.map { it.post.id })
            assertEquals(newest.items.map { it.post.id }.sortedDescending(), newest.items.map { it.post.id })
        }

    @Test
    fun `anonymous get post returns the post and its community`() =
        runBlocking {
            val response = anonApi.getPost(GetPost(id = postId)).getOrThrow()

            assertEquals(SEED_POST_TITLE, response.post_view.post.name)
            assertEquals(communityId, response.community_view.community.id)
        }

    @Test
    fun `user can create a post`() =
        runBlocking {
            val post = user.api.newPost(title = unique("Created post "), body = "Some body")

            assertEquals(user.username, post.creator.name)
            assertEquals("Some body", post.post.body)
            assertEquals(post.post.id, anonApi.getPost(GetPost(id = post.post.id)).getOrThrow().post_view.post.id)
        }

    @Test
    fun `user can edit a post`() =
        runBlocking {
            val post = user.api.newPost()

            val edited = user.api.editPost(EditPost(post_id = post.post.id, name = "Edited title", body = "Edited body")).getOrThrow()

            assertEquals("Edited title", edited.post_view.post.name)
            assertEquals("Edited body", anonApi.getPost(GetPost(id = post.post.id)).getOrThrow().post_view.post.body)
        }

    @Test
    fun `user can delete a post`() =
        runBlocking {
            val post = user.api.newPost()

            val deleted = user.api.deletePost(DeletePost(post_id = post.post.id, deleted = true)).getOrThrow()
            assertTrue(deleted.post_view.post.deleted)

            val restored = user.api.deletePost(DeletePost(post_id = post.post.id, deleted = false)).getOrThrow()
            assertTrue(!restored.post_view.post.deleted)
        }

    @Test
    fun `user can vote on a post`() =
        runBlocking {
            val post = adminApi.newPost()

            val up = user.api.createPostLike(CreatePostLike(post.post.id, VoteAction.UpVote)).getOrThrow()
            assertEquals(VoteAction.UpVote, up.post_view.post_actions?.vote)

            val down = user.api.createPostLike(CreatePostLike(post.post.id, VoteAction.DownVote)).getOrThrow()
            assertEquals(VoteAction.DownVote, down.post_view.post_actions?.vote)

            val none = user.api.createPostLike(CreatePostLike(post.post.id, VoteAction.NoVote)).getOrThrow()
            assertEquals(VoteAction.NoVote, none.post_view.post_actions?.vote ?: VoteAction.NoVote)
        }

    @Test
    fun `user can save and unsave a post`() =
        runBlocking {
            val post = adminApi.newPost()

            val saved = user.api.savePost(SavePost(post.post.id, save = true)).getOrThrow()
            assertNotNull(saved.post_view.post_actions?.saved_at)
            assertNotNull(user.api.getPost(GetPost(id = post.post.id)).getOrThrow().post_view.post_actions?.saved_at)

            val unsaved = user.api.savePost(SavePost(post.post.id, save = false)).getOrThrow()
            assertNull(unsaved.post_view.post_actions?.saved_at)
        }

    @Test
    fun `user can mark a post as read`() =
        runBlocking {
            val post = adminApi.newPost()

            val read = user.api.markPostAsRead(MarkPostAsRead(post.post.id, read = true)).getOrThrow()

            assertNotNull(read.post_view.post_actions?.read_at)
        }

    @Test
    fun `user can hide a post`() =
        runBlocking {
            val post = adminApi.newPost()

            user.api.hidePost(HidePost(post.post.id, hide = true)).getOrThrow()

            assertNotNull(user.api.getPost(GetPost(id = post.post.id)).getOrThrow().post_view.post_actions?.hidden_at)
        }

    @Test
    fun `user can report a post`() =
        runBlocking {
            val post = adminApi.newPost()

            val report = user.api.createPostReport(CreatePostReport(post.post.id, reason = "E2E report")).getOrThrow()

            assertEquals("E2E report", report.post_report_view.post_report.reason)

            val reports = adminApi.listReports(ListReports(type_ = ReportType.Posts)).getOrThrow()
            assertTrue(
                reports.items.filterIsInstance<PostReportView>().any { it.post_report.id == report.post_report_view.post_report.id },
            )
        }

    @Test
    fun `subscribed feed contains posts of followed communities`() =
        runBlocking {
            val follower = newUser()
            val community = adminApi.newCommunity()
            val post = adminApi.newPost(inCommunity = community)
            assertTrue(
                follower.api.getPosts(GetPosts(type_ = ListingType.Subscribed)).getOrThrow().items.none { it.post.id == post.post.id },
            )

            follower.api.followCommunity(FollowCommunity(community, follow = true)).getOrThrow()

            val feed = follower.api.getPosts(GetPosts(type_ = ListingType.Subscribed)).getOrThrow()
            assertTrue(feed.items.any { it.post.id == post.post.id })
        }
}
