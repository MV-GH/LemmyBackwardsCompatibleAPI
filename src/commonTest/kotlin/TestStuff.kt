import io.ktor.http.*
import it.vercruysse.lemmyapi.LemmyApi
import kotlin.test.Test


class TestStuff  {

    @Test
    fun test() {
        val url = Url("lemmy.ml")
        println(url.protocol)
    }
}


