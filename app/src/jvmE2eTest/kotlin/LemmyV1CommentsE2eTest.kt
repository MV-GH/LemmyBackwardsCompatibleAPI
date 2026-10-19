import it.vercruysse.lemmyapi.datatypes.CreateCommentLike
import it.vercruysse.lemmyapi.datatypes.CreateCommentReport
import it.vercruysse.lemmyapi.datatypes.DeleteComment
import it.vercruysse.lemmyapi.datatypes.EditComment
import it.vercruysse.lemmyapi.datatypes.GetComment
import it.vercruysse.lemmyapi.datatypes.GetComments
import it.vercruysse.lemmyapi.datatypes.SaveComment
import it.vercruysse.lemmyapi.enums.CommentSortType
import it.vercruysse.lemmyapi.enums.VoteAction
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LemmyV1CommentsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous comment list returns the seeded comment`() =
        runBlocking {
            val response = anonApi.getComments(GetComments(post_id = postId)).getOrThrow()
            val comment = response.items.single { it.comment.content == SEED_COMMENT_CONTENT }

            assertEquals(postId, comment.post.id)
            assertEquals(SEED_POST_TITLE, comment.post.name)
            assertEquals(ADMIN_USERNAME, comment.creator.name)
            assertTrue(comment.comment.published_at.isNotBlank())
            assertNull(comment.comment_actions)
        }

    @Test
    fun `anonymous comment list can be paged`() =
        runBlocking {
            val pages =
                fetchPages { cursor ->
                    anonApi.getComments(GetComments(post_id = postId, limit = 2, sort = CommentSortType.Old, page_cursor = cursor))
                }
            val ids = pages.flatten().map { it.comment.id }

            assertTrue(pages.size >= 3, "Expected multiple pages but got ${pages.size}")
            assertEquals(2, pages.first().size)
            assertEquals(ids.distinct(), ids, "Pages must not repeat comments")
            assertTrue(ids.containsAll(seededCommentIds))
        }

    @Test
    fun `anonymous get comment returns the seeded comment`() =
        runBlocking {
            val response = anonApi.getComment(GetComment(id = commentId)).getOrThrow()

            assertEquals(SEED_COMMENT_CONTENT, response.comment_view.comment.content)
            assertEquals(postId, response.comment_view.post.id)
        }

    @Test
    fun `replies are nested under their parent`() =
        runBlocking {
            val post = adminApi.newPost()
            val parent = adminApi.newComment(onPost = post.post.id)
            val reply = user.api.newComment(onPost = post.post.id, parent = parent.comment.id)

            assertEquals(user.username, reply.creator.name)
            assertTrue(reply.comment.path.contains(".${parent.comment.id}."), "Unexpected path ${reply.comment.path}")

            val children = anonApi.getComments(GetComments(post_id = post.post.id, parent_id = parent.comment.id)).getOrThrow()
            assertTrue(children.items.any { it.comment.id == reply.comment.id })
        }

    @Test
    fun `user can create a comment`() =
        runBlocking {
            val post = adminApi.newPost()

            val comment = user.api.newComment(content = "Hello from the user", onPost = post.post.id)

            assertEquals("Hello from the user", comment.comment.content)
            assertEquals(user.username, comment.creator.name)
            val listed = anonApi.getComments(GetComments(post_id = post.post.id)).getOrThrow()
            assertEquals(listOf(comment.comment.id), listed.items.map { it.comment.id })
        }

    @Test
    fun `user can edit a comment`() =
        runBlocking {
            val comment = user.api.newComment()

            val edited = user.api.editComment(EditComment(comment.comment.id, content = "Edited content")).getOrThrow()

            assertEquals("Edited content", edited.comment_view.comment.content)
            assertEquals("Edited content", anonApi.getComment(GetComment(comment.comment.id)).getOrThrow().comment_view.comment.content)
        }

    @Test
    fun `user can delete a comment`() =
        runBlocking {
            val comment = user.api.newComment()

            val deleted = user.api.deleteComment(DeleteComment(comment.comment.id, deleted = true)).getOrThrow()

            assertTrue(deleted.comment_view.comment.deleted)
        }

    @Test
    fun `user can vote on a comment`() =
        runBlocking {
            val comment = adminApi.newComment()

            val up = user.api.createCommentLike(CreateCommentLike(comment.comment.id, VoteAction.UpVote)).getOrThrow()
            assertEquals(VoteAction.UpVote, up.comment_view.comment_actions?.vote)

            val down = user.api.createCommentLike(CreateCommentLike(comment.comment.id, VoteAction.DownVote)).getOrThrow()
            assertEquals(VoteAction.DownVote, down.comment_view.comment_actions?.vote)
        }

    @Test
    fun `user can save and unsave a comment`() =
        runBlocking {
            val comment = adminApi.newComment()

            val saved = user.api.saveComment(SaveComment(comment.comment.id, save = true)).getOrThrow()
            assertNotNull(saved.comment_view.comment_actions?.saved_at)

            val unsaved = user.api.saveComment(SaveComment(comment.comment.id, save = false)).getOrThrow()
            assertNull(unsaved.comment_view.comment_actions?.saved_at)
        }

    @Test
    fun `user can report a comment`() =
        runBlocking {
            val comment = adminApi.newComment()

            val report = user.api.createCommentReport(CreateCommentReport(comment.comment.id, reason = "E2E report")).getOrThrow()

            assertEquals("E2E report", report.comment_report_view.comment_report.reason)
        }
}
