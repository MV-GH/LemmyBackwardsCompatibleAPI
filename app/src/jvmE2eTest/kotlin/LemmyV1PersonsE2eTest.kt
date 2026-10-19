import it.vercruysse.lemmyapi.datatypes.BlockPerson
import it.vercruysse.lemmyapi.datatypes.CommentView
import it.vercruysse.lemmyapi.datatypes.GetPersonDetails
import it.vercruysse.lemmyapi.datatypes.ListPersonContent
import it.vercruysse.lemmyapi.datatypes.ListPersonSaved
import it.vercruysse.lemmyapi.datatypes.PostView
import it.vercruysse.lemmyapi.datatypes.SavePost
import it.vercruysse.lemmyapi.enums.PersonContentType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1PersonsE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous person details returns the seeded administrator`() =
        runBlocking {
            val response = anonApi.getPersonDetails(GetPersonDetails(username = ADMIN_USERNAME)).getOrThrow()
            val person = response.person_view.person

            assertEquals(ADMIN_USERNAME, person.name)
            assertTrue(person.local)
            assertTrue(response.person_view.is_admin)
            assertTrue(person.published_at.isNotBlank())
        }

    @Test
    fun `anonymous person details can be fetched by id`() =
        runBlocking {
            val response = anonApi.getPersonDetails(GetPersonDetails(person_id = user.personId)).getOrThrow()

            assertEquals(user.username, response.person_view.person.name)
        }

    @Test
    fun `person content can be paged`() =
        runBlocking {
            val pages =
                fetchPages { cursor ->
                    anonApi.listPersonContent(ListPersonContent(username = ADMIN_USERNAME, limit = 4, page_cursor = cursor))
                }
            val items = pages.flatten()

            assertTrue(pages.size >= 3, "Expected multiple pages but got ${pages.size}")
            assertEquals(4, pages.first().size)
            assertEquals(items.distinct().size, items.size, "Pages must not repeat content")
            assertTrue(items.filterIsInstance<PostView>().map { it.post.id }.containsAll(seededPostIds))
            assertTrue(items.filterIsInstance<CommentView>().map { it.comment.id }.containsAll(seededCommentIds))
        }

    @Test
    fun `person content can be filtered by type`() =
        runBlocking {
            val posts =
                anonApi.listPersonContent(ListPersonContent(username = ADMIN_USERNAME, type_ = PersonContentType.Posts)).getOrThrow()
            val comments =
                anonApi.listPersonContent(ListPersonContent(username = ADMIN_USERNAME, type_ = PersonContentType.Comments)).getOrThrow()

            assertTrue(posts.items.isNotEmpty() && posts.items.all { it is PostView })
            assertTrue(comments.items.isNotEmpty() && comments.items.all { it is CommentView })
        }

    @Test
    fun `saved content shows up in the saved list`() =
        runBlocking {
            val saver = newUser()
            val post = adminApi.newPost()
            saver.api.savePost(SavePost(post.post.id, save = true)).getOrThrow()

            val saved = saver.api.listPersonSaved(ListPersonSaved()).getOrThrow()

            assertEquals(listOf(post.post.id), saved.items.filterIsInstance<PostView>().map { it.post.id })
        }

    @Test
    fun `user can block and unblock another person`() =
        runBlocking {
            val blocker = newUser()
            val target = newUser()

            blocker.api.blockPerson(BlockPerson(target.personId, block = true)).getOrThrow()
            assertEquals(listOf(target.personId), blocker.api.getMyUser().getOrThrow().person_blocks.map { it.id })

            blocker.api.blockPerson(BlockPerson(target.personId, block = false)).getOrThrow()
            assertTrue(blocker.api.getMyUser().getOrThrow().person_blocks.isEmpty())
        }
}
