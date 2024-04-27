import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApi
import it.vercruysse.lemmyapi.v0x19.datatypes.GetPosts
import it.vercruysse.lemmyapi.v0x19.datatypes.ListMedia
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TestStuff {
    @Test
    fun test() {
        val url = Url("lemmy.ml")
        println(url.protocol)
    }

    @Test
    fun test2() = runTest {
        val api = LemmyApi.getLemmyApi("lemmy.ml")

        println(api.version)
        println(api.getSite())
        println(api.getPosts(GetPosts()))
        println(api.listMedia(ListMedia()))
    }
}
