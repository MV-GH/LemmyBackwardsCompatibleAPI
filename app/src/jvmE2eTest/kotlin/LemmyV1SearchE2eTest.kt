import it.vercruysse.lemmyapi.datatypes.Search
import it.vercruysse.lemmyapi.enums.SearchType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1SearchE2eTest : LemmyV1E2eTest() {
    @Test
    fun `search finds posts`() =
        runBlocking {
            val response = anonApi.search(Search(search_term = SEED_POST_TITLE, type_ = SearchType.Posts)).getOrThrow()

            assertTrue(response.posts.any { it.post.id == postId })
        }

    @Test
    fun `search finds comments`() =
        runBlocking {
            val response = anonApi.search(Search(search_term = SEED_COMMENT_CONTENT, type_ = SearchType.Comments)).getOrThrow()

            assertTrue(response.comments.any { it.comment.id == commentId })
        }

    @Test
    fun `search finds communities`() =
        runBlocking {
            val response = anonApi.search(Search(search_term = SEED_COMMUNITY_NAME, type_ = SearchType.Communities)).getOrThrow()

            assertTrue(response.communities.any { it.community.id == communityId })
        }

    @Test
    fun `search finds users`() =
        runBlocking {
            val response = anonApi.search(Search(search_term = user.username, type_ = SearchType.Users)).getOrThrow()

            assertTrue(response.persons.any { it.person.id == user.personId })
        }

    @Test
    fun `search results can be paged`() =
        runBlocking {
            val ids = mutableListOf<Long>()
            var pages = 0
            var cursor: String? = null
            do {
                val response =
                    anonApi.search(
                        Search(search_term = "E2E paging post", type_ = SearchType.Posts, limit = 2, page_cursor = cursor),
                    ).getOrThrow()
                ids += response.posts.map { it.post.id }
                cursor = response.next_page
                pages++
            } while (cursor != null && pages < 20)

            assertTrue(pages >= 3, "Expected multiple pages but got $pages")
            assertEquals(ids.distinct(), ids, "Pages must not repeat posts")
            assertTrue(ids.containsAll(seededPostIds.drop(1)))
        }
}
