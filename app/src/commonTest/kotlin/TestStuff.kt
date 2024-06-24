import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApi
import it.vercruysse.lemmyapi.datatypes.GetPosts
import kotlinx.coroutines.test.runTest
import kotlin.test.Ignore
import kotlin.test.Test

@Ignore
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
    }
}
