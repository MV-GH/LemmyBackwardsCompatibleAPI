import it.vercruysse.lemmyapi.LemmyApiBaseController
import it.vercruysse.lemmyapi.datatypes.CreateMultiCommunity
import it.vercruysse.lemmyapi.datatypes.CreateOrDeleteMultiCommunityEntry
import it.vercruysse.lemmyapi.datatypes.EditMultiCommunity
import it.vercruysse.lemmyapi.datatypes.FollowMultiCommunity
import it.vercruysse.lemmyapi.datatypes.GetMultiCommunity
import it.vercruysse.lemmyapi.datatypes.GetPersonDetails
import it.vercruysse.lemmyapi.datatypes.ListMultiCommunities
import it.vercruysse.lemmyapi.datatypes.MultiCommunityView
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import it.vercruysse.lemmyapi.enums.MultiCommunityListingType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LemmyV1MultiCommunitiesE2eTest : LemmyV1E2eTest() {
    private suspend fun LemmyApiBaseController.newMulti(): MultiCommunityView =
        createMultiCommunity(CreateMultiCommunity(name = unique("e2em"), title = "E2E multi", summary = "E2E summary"))
            .getOrThrow().multi_community_view

    private suspend fun LemmyApiBaseController.multis(form: ListMultiCommunities = ListMultiCommunities()): List<MultiCommunityView> =
        fetchPages { listMultiCommunities(form.copy(page_cursor = it)) }.flatten()

    @Test
    fun `created multi community can be read by id and name`() =
        runBlocking {
            val created = user.api.newMulti()
            assertEquals(user.personId, created.owner.id)
            assertEquals("E2E multi", created.multi.title)
            assertEquals(0L, created.multi.communities)

            val byId = anonApi.getMultiCommunity(GetMultiCommunity(id = created.multi.id)).getOrThrow()
            assertEquals(created.multi.name, byId.multi_community_view.multi.name)
            assertTrue(byId.communities.isEmpty())

            val byName = anonApi.getMultiCommunity(GetMultiCommunity(name = created.multi.name)).getOrThrow()
            assertEquals(created.multi.id, byName.multi_community_view.multi.id)
        }

    @Test
    fun `communities can be added to and removed from a multi community`() =
        runBlocking {
            val multi = user.api.newMulti().multi
            val other = adminApi.newCommunity()

            val added = user.api.createMultiCommunityEntry(CreateOrDeleteMultiCommunityEntry(multi.id, communityId))
                .getOrThrow().community_view
            assertEquals(communityId, added.community.id)
            user.api.createMultiCommunityEntry(CreateOrDeleteMultiCommunityEntry(multi.id, other)).getOrThrow()

            val withBoth = anonApi.getMultiCommunity(GetMultiCommunity(id = multi.id)).getOrThrow()
            assertEquals(setOf(communityId, other), withBoth.communities.map { it.community.id }.toSet())

            user.api.deleteMultiCommunityEntry(CreateOrDeleteMultiCommunityEntry(multi.id, other)).getOrThrow()
            val withOne = anonApi.getMultiCommunity(GetMultiCommunity(id = multi.id)).getOrThrow()
            assertEquals(listOf(communityId), withOne.communities.map { it.community.id })
        }

    @Test
    fun `only the owner can change a multi community`() =
        runBlocking {
            val multi = user.api.newMulti().multi
            val stranger = newUser()

            assertTrue(stranger.api.editMultiCommunity(EditMultiCommunity(multi.id, title = "hijacked")).isFailure)
            assertTrue(stranger.api.createMultiCommunityEntry(CreateOrDeleteMultiCommunityEntry(multi.id, communityId)).isFailure)
        }

    @Test
    fun `multi community can be edited and deleted`() =
        runBlocking {
            val multi = user.api.newMulti().multi

            val edited = user.api.editMultiCommunity(EditMultiCommunity(multi.id, title = "E2E edited", sidebar = "E2E sidebar"))
                .getOrThrow().multi_community_view.multi
            assertEquals("E2E edited", edited.title)
            assertEquals("E2E sidebar", edited.sidebar)
            assertEquals("E2E summary", edited.summary)

            val deleted = user.api.editMultiCommunity(EditMultiCommunity(multi.id, deleted = true))
                .getOrThrow().multi_community_view.multi
            assertTrue(deleted.deleted)
        }

    @Test
    fun `followed multi community shows in the subscribed list`() =
        runBlocking {
            val multi = user.api.newMulti().multi
            val follower = newUser()

            val followed = follower.api.followMultiCommunity(FollowMultiCommunity(multi.id, true))
                .getOrThrow().multi_community_view
            assertEquals(CommunityFollowerState.Accepted, followed.follow_state)
            assertTrue(follower.api.multis(ListMultiCommunities(type_ = MultiCommunityListingType.Subscribed)).any { it.multi.id == multi.id })

            val unfollowed = follower.api.followMultiCommunity(FollowMultiCommunity(multi.id, false))
                .getOrThrow().multi_community_view
            assertNull(unfollowed.follow_state)
            assertFalse(follower.api.multis(ListMultiCommunities(type_ = MultiCommunityListingType.Subscribed)).any { it.multi.id == multi.id })
        }

    @Test
    fun `multi communities can be listed by creator and are shown on the profile`() =
        runBlocking {
            val owner = newUser()
            val first = owner.api.newMulti().multi
            val second = owner.api.newMulti().multi

            val listed = anonApi.multis(ListMultiCommunities(creator_id = owner.personId))
            assertEquals(setOf(first.id, second.id), listed.map { it.multi.id }.toSet())
            assertTrue(anonApi.multis().map { it.multi.id }.containsAll(listOf(first.id, second.id)))

            val profile = anonApi.getPersonDetails(GetPersonDetails(person_id = owner.personId)).getOrThrow()
            assertEquals(setOf(first.id, second.id), profile.multi_communities_created.map { it.multi.id }.toSet())
        }
}
