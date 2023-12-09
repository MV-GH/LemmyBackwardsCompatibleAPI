import io.ktor.http.*
import kotlin.test.Test

class TestStuff {
    @Test
    fun test() {
        val url = Url("lemmy.ml")
        println(url.protocol)
    }
}
