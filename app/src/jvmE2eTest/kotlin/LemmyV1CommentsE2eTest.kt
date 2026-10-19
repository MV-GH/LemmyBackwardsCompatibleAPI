import it.vercruysse.lemmyapi.datatypes.GetComments
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1CommentsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous comment list returns the seeded comment`() =
        runBlocking {
            val response = api.getComments(GetComments(post_id = postId)).getOrThrow()
            val comment = response.items.single { it.comment.content == SEED_COMMENT_CONTENT }

            assertEquals(postId, comment.post.id)
            assertEquals(SEED_POST_TITLE, comment.post.name)
            assertEquals(ADMIN_USERNAME, comment.creator.name)
            assertTrue(comment.comment.published_at.isNotBlank())
        }
}
