import it.vercruysse.lemmyapi.datatypes.GetPosts
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1PostsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous post list returns the seeded post`() =
        runBlocking {
            val response = api.getPosts(GetPosts(community_name = SEED_COMMUNITY_NAME)).getOrThrow()
            val post = response.items.single { it.post.id == postId }

            assertEquals(SEED_POST_TITLE, post.post.name)
            assertEquals(SEED_POST_BODY, post.post.body)
            assertEquals(ADMIN_USERNAME, post.creator.name)
            assertTrue(post.post.published_at.isNotBlank())
        }
}
