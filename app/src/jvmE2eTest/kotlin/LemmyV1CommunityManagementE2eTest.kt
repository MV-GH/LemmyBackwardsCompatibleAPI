import it.vercruysse.lemmyapi.datatypes.AddModToCommunity
import it.vercruysse.lemmyapi.datatypes.ApproveCommunityPendingFollower
import it.vercruysse.lemmyapi.datatypes.CommunityIdQuery
import it.vercruysse.lemmyapi.datatypes.CreateCommunity
import it.vercruysse.lemmyapi.datatypes.CreateCommunityTag
import it.vercruysse.lemmyapi.datatypes.DeleteCommunity
import it.vercruysse.lemmyapi.datatypes.DeleteCommunityTag
import it.vercruysse.lemmyapi.datatypes.EditCommunity
import it.vercruysse.lemmyapi.datatypes.EditCommunityNotifications
import it.vercruysse.lemmyapi.datatypes.EditCommunityTag
import it.vercruysse.lemmyapi.datatypes.FollowCommunity
import it.vercruysse.lemmyapi.datatypes.GetCommunity
import it.vercruysse.lemmyapi.datatypes.GetRandomCommunity
import it.vercruysse.lemmyapi.datatypes.ListCommunityPendingFollows
import it.vercruysse.lemmyapi.datatypes.RemoveCommunity
import it.vercruysse.lemmyapi.datatypes.TransferCommunity
import it.vercruysse.lemmyapi.enums.CommunityFollowerState
import it.vercruysse.lemmyapi.enums.CommunityNotificationsMode
import it.vercruysse.lemmyapi.enums.CommunityVisibility
import it.vercruysse.lemmyapi.enums.ListingType
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LemmyV1CommunityManagementE2eTest : LemmyV1E2eTest() {
    @Test
    fun `moderator can edit a community`() =
        runBlocking<Unit> {
            val owner = newUser()
            val community = owner.api.newCommunity()

            val edited =
                owner.api.editCommunity(EditCommunity(community, title = "Edited title", summary = "Edited summary"))
                    .getOrThrow().community_view.community

            assertEquals("Edited title", edited.title)
            assertEquals("Edited summary", anonApi.getCommunity(GetCommunity(id = community)).getOrThrow().community_view.community.summary)
        }

    @Test
    fun `owner can delete and restore a community`() =
        runBlocking<Unit> {
            val owner = newUser()
            val community = owner.api.newCommunity()

            assertTrue(owner.api.deleteCommunity(DeleteCommunity(community, true)).getOrThrow().community_view.community.deleted)
            assertFalse(owner.api.deleteCommunity(DeleteCommunity(community, false)).getOrThrow().community_view.community.deleted)
        }

    @Test
    fun `admin can remove and restore a community`() =
        runBlocking<Unit> {
            val community = newUser().api.newCommunity()

            assertTrue(
                adminApi.removeCommunity(RemoveCommunity(community, true, "e2e remove")).getOrThrow().community_view.community.removed,
            )
            assertFalse(
                adminApi.removeCommunity(RemoveCommunity(community, false, "e2e restore")).getOrThrow().community_view.community.removed,
            )
        }

    @Test
    fun `moderator can be added and the community transferred`() =
        runBlocking<Unit> {
            val owner = newUser()
            val mod = newUser()
            val community = owner.api.newCommunity()

            val mods = owner.api.addModToCommunity(AddModToCommunity(community, mod.personId, added = true)).getOrThrow().moderators
            assertEquals(listOf(owner.personId, mod.personId), mods.map { it.moderator.id })

            val transferred = owner.api.transferCommunity(TransferCommunity(community, mod.personId)).getOrThrow()
            assertEquals(mod.personId, transferred.moderators.first().moderator.id)
        }

    @Test
    fun `random community returns a local community`() =
        runBlocking<Unit> {
            val community = anonApi.getRandomCommunity(GetRandomCommunity(type_ = ListingType.Local)).getOrThrow().community_view

            assertTrue(community.community.local)
        }

    @Test
    fun `user can change the notifications of a community`() =
        runBlocking<Unit> {
            val follower = newUser()
            val community = adminApi.newCommunity()
            follower.api.followCommunity(FollowCommunity(community, follow = true)).getOrThrow()

            follower.api.editCommunityNotifications(EditCommunityNotifications(community, CommunityNotificationsMode.Mute)).getOrThrow()

            val actions = follower.api.getCommunity(GetCommunity(id = community)).getOrThrow().community_view.community_actions
            assertEquals(CommunityNotificationsMode.Mute, actions?.notifications)
        }

    @Test
    fun `community tags can be created, edited and deleted`() =
        runBlocking<Unit> {
            val community = adminApi.newCommunity()

            val tag = adminApi.createCommunityTag(CreateCommunityTag(community, name = unique("e2etag"), display_name = "E2E tag"))
                .getOrThrow()
            assertEquals(listOf(tag.id), adminApi.getCommunity(GetCommunity(id = community)).getOrThrow().community_view.tags.map { it.id })

            val edited = adminApi.editCommunityTag(EditCommunityTag(tag.id, display_name = "Edited tag")).getOrThrow()
            assertEquals("Edited tag", edited.display_name)

            assertTrue(adminApi.deleteCommunityTag(DeleteCommunityTag(tag.id, delete = true)).getOrThrow().deleted)
        }

    @Test
    fun `pending follow of a private community can be approved`() =
        runBlocking<Unit> {
            val owner = newUser()
            val follower = newUser()
            val community =
                owner.api.createCommunity(
                    CreateCommunity(name = unique("e2epriv"), title = "E2E private", visibility = CommunityVisibility.Private),
                ).getOrThrow().community_view.community.id

            follower.api.followCommunity(FollowCommunity(community, follow = true)).getOrThrow()

            val pending = owner.api.listCommunityPendingFollows(ListCommunityPendingFollows()).getOrThrow().items
            assertEquals(listOf(follower.personId), pending.filter { it.community.id == community }.map { it.person.id })

            owner.api.approveCommunityPendingFollow(ApproveCommunityPendingFollower(community, follower.personId, approve = true))
                .getOrThrow()

            val state = follower.api.getCommunity(GetCommunity(id = community)).getOrThrow().community_view.community_actions?.follow_state
            assertEquals(CommunityFollowerState.Accepted, state)
        }

    @Test
    fun `moderator can upload and delete the community icon and banner`() =
        runBlocking<Unit> {
            val owner = newUser()
            val community = owner.api.newCommunity()
            val query = CommunityIdQuery(community)

            val icon = owner.api.uploadCommunityIcon(PNG, query).getOrThrow()
            val banner = owner.api.uploadCommunityBanner(PNG, query).getOrThrow()
            val uploaded = anonApi.getCommunity(GetCommunity(id = community)).getOrThrow().community_view.community
            assertEquals(icon.image_url, uploaded.icon)
            assertEquals(banner.image_url, uploaded.banner)

            owner.api.deleteCommunityIcon(query).getOrThrow()
            owner.api.deleteCommunityBanner(query).getOrThrow()
            val deleted = anonApi.getCommunity(GetCommunity(id = community)).getOrThrow().community_view.community
            assertNull(deleted.icon)
            assertNull(deleted.banner)
        }
}
