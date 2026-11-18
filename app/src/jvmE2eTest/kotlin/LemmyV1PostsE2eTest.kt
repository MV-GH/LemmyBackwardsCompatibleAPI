import it.vercruysse.lemmyapi.datatypes.CreatePostLike
import it.vercruysse.lemmyapi.datatypes.CreatePostReport
import it.vercruysse.lemmyapi.datatypes.CreatePostWarning
import it.vercruysse.lemmyapi.datatypes.DeletePost
import it.vercruysse.lemmyapi.datatypes.EditPost
import it.vercruysse.lemmyapi.datatypes.EditPostNotifications
import it.vercruysse.lemmyapi.datatypes.FollowCommunity
import it.vercruysse.lemmyapi.datatypes.GetPost
import it.vercruysse.lemmyapi.datatypes.GetPosts
import it.vercruysse.lemmyapi.datatypes.HidePost
import it.vercruysse.lemmyapi.datatypes.HidePosts
import it.vercruysse.lemmyapi.datatypes.ListPersonHidden
import it.vercruysse.lemmyapi.datatypes.ListPersonRead
import it.vercruysse.lemmyapi.datatypes.ListPostLikes
import it.vercruysse.lemmyapi.datatypes.ListReports
import it.vercruysse.lemmyapi.datatypes.MarkManyPostsAsRead
import it.vercruysse.lemmyapi.datatypes.MarkPostAsRead
import it.vercruysse.lemmyapi.datatypes.ModEditPost
import it.vercruysse.lemmyapi.datatypes.PostReportView
import it.vercruysse.lemmyapi.datatypes.SavePost
import it.vercruysse.lemmyapi.enums.ListingType
import it.vercruysse.lemmyapi.enums.PostNotificationsMode
import it.vercruysse.lemmyapi.enums.ReportType
import it.vercruysse.lemmyapi.enums.SortType
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.coroutines.runBlocking
import java.time.Instant
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LemmyV1PostsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous post list returns the seeded post`() =
        runBlocking {
            val posts = fetchPages { cursor -> anonApi.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME, page_cursor = cursor)) }
            val post = posts.flatten().single { it.post.id == postId }

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

            // Lemmy sorts on published_at, which doesn't always follow the post id
            val oldestPublished = oldest.items.map { Instant.parse(it.post.published_at) }
            val newestPublished = newest.items.map { Instant.parse(it.post.published_at) }
            assertEquals(oldestPublished.sorted(), oldestPublished)
            assertEquals(newestPublished.sortedDescending(), newestPublished)
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
        runBlocking<Unit> {
            val post = adminApi.newPost()

            val read = user.api.markPostAsRead(MarkPostAsRead(post.post.id, read = true)).getOrThrow()

            assertNotNull(read.post_view.post_actions?.read_at)
        }

    @Test
    fun `user can hide a post`() =
        runBlocking<Unit> {
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

    @Test
    fun `user can hide many posts and list them`() =
        runBlocking<Unit> {
            val hider = newUser()
            val posts = List(2) { adminApi.newPost().post.id }

            hider.api.hidePosts(HidePosts(posts, hide = true)).getOrThrow()

            assertEquals(posts.toSet(), hider.api.listPersonHidden(ListPersonHidden()).getOrThrow().items.map { it.post.id }.toSet())
        }

    @Test
    fun `user can mark many posts as read and list them`() =
        runBlocking<Unit> {
            val reader = newUser()
            val posts = List(2) { adminApi.newPost().post.id }

            reader.api.markManyPostsAsRead(MarkManyPostsAsRead(posts, read = true)).getOrThrow()

            assertEquals(posts.toSet(), reader.api.listPersonRead(ListPersonRead()).getOrThrow().items.map { it.post.id }.toSet())
        }

    @Test
    fun `admin can list the votes on a post`() =
        runBlocking<Unit> {
            val voter = newUser()
            val post = adminApi.newPost()
            voter.api.createPostLike(CreatePostLike(post.post.id, VoteAction.UpVote)).getOrThrow()

            val likes = adminApi.listPostLikes(ListPostLikes(post.post.id)).getOrThrow().items

            // The creator automatically upvotes its own post
            assertEquals(setOf(post.creator.id, voter.personId), likes.filter { it.vote == VoteAction.UpVote }.map { it.creator.id }.toSet())
        }

    @Test
    fun `moderator can mark a post as nsfw`() =
        runBlocking<Unit> {
            val post = user.api.newPost()

            val edited = adminApi.modEditPost(ModEditPost(post.post.id, nsfw = true)).getOrThrow()

            assertTrue(edited.post_view.post.nsfw)
        }

    @Test
    fun `moderator can warn a post`() =
        runBlocking<Unit> {
            val post = user.api.newPost()

            val warned = adminApi.warnPost(CreatePostWarning(post.post.id, "e2e warning")).getOrThrow()

            assertEquals(post.post.id, warned.post_view.post.id)
        }

    @Test
    fun `user can change the notifications of a post`() =
        runBlocking<Unit> {
            val watcher = newUser()
            val post = adminApi.newPost()

            watcher.api.editPostNotifications(EditPostNotifications(post.post.id, PostNotificationsMode.Mute)).getOrThrow()

            val actions = watcher.api.getPost(GetPost(id = post.post.id)).getOrThrow().post_view.post_actions
            assertEquals(PostNotificationsMode.Mute, actions?.notifications)
        }
}
