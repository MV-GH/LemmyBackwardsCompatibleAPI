import it.vercruysse.lemmyapi.datatypes.CreateCommunity
import it.vercruysse.lemmyapi.datatypes.EditCommunity
import kotlin.test.Test
import kotlin.test.assertEquals

class LegacyCommunitySidebarTest {
    private val create = { sidebar: String?, summary: String? ->
        CreateCommunity(name = "c", title = "C", sidebar = sidebar, summary = summary)
    }
    private val edit = { sidebar: String?, summary: String? ->
        EditCommunity(community_id = 1, sidebar = sidebar, summary = summary)
    }

    @Test
    fun `pre 1_0 description is sent from sidebar, falling back to summary`() {
        val x5 = it.vercruysse.lemmyapi.v0.x18.x5.Transformer("token")
        val x0 = it.vercruysse.lemmyapi.v0.x19.x0.Transformer()
        val x11 = it.vercruysse.lemmyapi.v0.x19.x11.Transformer()

        assertEquals("side", x5.fromUni(create("side", "sum")).description)
        assertEquals("sum", x5.fromUni(create(null, "sum")).description)
        assertEquals("side", x0.fromUni(edit("side", "sum")).description)
        assertEquals("sum", x0.fromUni(edit(null, "sum")).description)
        assertEquals("side", x11.fromUni(create("side", null)).description)
        assertEquals("sum", x11.fromUni(edit(null, "sum")).description)
    }
}
