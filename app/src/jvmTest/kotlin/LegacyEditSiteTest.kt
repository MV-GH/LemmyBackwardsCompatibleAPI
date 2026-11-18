import kotlin.test.Test
import kotlin.test.assertEquals

class LegacyEditSiteTest {
    @Test
    fun `nsfw_content_disallowed replaces enable_nsfw pre 1_0`() {
        val form = it.vercruysse.lemmyapi.datatypes.EditSite(nsfw_content_disallowed = true)
        assertEquals(false, it.vercruysse.lemmyapi.v0.x18.x5.Transformer("token").fromUni(form).enable_nsfw)
        assertEquals(false, it.vercruysse.lemmyapi.v0.x19.x0.Transformer().fromUni(form).enable_nsfw)
        assertEquals(false, it.vercruysse.lemmyapi.v0.x19.x11.Transformer().fromUni(form).enable_nsfw)
    }
}
