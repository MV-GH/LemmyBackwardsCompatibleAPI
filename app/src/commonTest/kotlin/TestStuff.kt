import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApi
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
        val api = LemmyApi.getLemmyApi("voyager.lemmy.ml", auth = VOYAGER_AUTH)

        println(api.version)
        println(api.getSite())
        println(api.listMedia(ListMedia()))
    }
}
