import it.vercruysse.lemmyapi.datatypes.BlockCommunity
import it.vercruysse.lemmyapi.datatypes.FollowCommunity
import it.vercruysse.lemmyapi.datatypes.GetCommunity
import it.vercruysse.lemmyapi.datatypes.ListCommunities
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LemmyV1CommunitiesE2eTest : LemmyV1E2eTest() {
    @Test
    fun `anonymous get community by name and id`() =
        runBlocking {
            val byName = anonApi.getCommunity(GetCommunity(name = SEED_COMMUNITY_NAME)).getOrThrow()
            val byId = anonApi.getCommunity(GetCommunity(id = communityId)).getOrThrow()

            assertEquals(communityId, byName.community_view.community.id)
            assertEquals(SEED_COMMUNITY_NAME, byId.community_view.community.name)
            assertTrue(byName.community_view.community.local)
        }

    @Test
    fun `anonymous community list contains the seeded community`() =
        runBlocking {
            val response = anonApi.listCommunities(ListCommunities()).getOrThrow()

            assertTrue(response.items.any { it.community.id == communityId })
        }

    @Test
    fun `community list can be paged`() =
        runBlocking {
            val created = List(3) { adminApi.newCommunity() }

            val pages = fetchPages { cursor -> anonApi.listCommunities(ListCommunities(limit = 2, page_cursor = cursor)) }
            val ids = pages.flatten().map { it.community.id }

            assertTrue(pages.size >= 2, "Expected multiple pages but got ${pages.size}")
            assertEquals(2, pages.first().size)
            assertEquals(ids.distinct(), ids, "Pages must not repeat communities")
            assertTrue(ids.containsAll(created))
        }

    @Test
    fun `user can create a community and becomes its moderator`() =
        runBlocking {
            val creator = newUser()

            val id = creator.api.newCommunity()

            assertTrue(creator.api.getMyUser().getOrThrow().moderates.any { it.community.id == id })
            assertEquals(id, anonApi.getCommunity(GetCommunity(id = id)).getOrThrow().community_view.community.id)
        }

    @Test
    fun `user can follow and unfollow a community`() =
        runBlocking {
            val follower = newUser()
            val community = adminApi.newCommunity()

            follower.api.followCommunity(FollowCommunity(community, follow = true)).getOrThrow()
            assertTrue(follower.api.getMyUser().getOrThrow().follows.any { it.community.id == community })

            follower.api.followCommunity(FollowCommunity(community, follow = false)).getOrThrow()
            assertTrue(follower.api.getMyUser().getOrThrow().follows.none { it.community.id == community })
        }

    @Test
    fun `user can block and unblock a community`() =
        runBlocking {
            val blocker = newUser()
            val community = adminApi.newCommunity()

            blocker.api.blockCommunity(BlockCommunity(community, block = true)).getOrThrow()
            assertEquals(listOf(community), blocker.api.getMyUser().getOrThrow().community_blocks.map { it.id })

            blocker.api.blockCommunity(BlockCommunity(community, block = false)).getOrThrow()
            assertTrue(blocker.api.getMyUser().getOrThrow().community_blocks.isEmpty())
        }
}
