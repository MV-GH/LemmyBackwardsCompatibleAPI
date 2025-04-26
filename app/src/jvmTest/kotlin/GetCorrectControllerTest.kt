import it.vercruysse.lemmyapi.LemmyApi
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test

class GetCorrectControllerTest {

    @Test
    fun `getLemmyApi should return the correct LemmyApiBaseController`() {
        val controller = LemmyApi.getLemmyApi(instance = "lemmy.world", version = "0.19.3-3-g25987dba3")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller)

        val controller2 = LemmyApi.getLemmyApi(instance = "lemmy.world", version = "0.19.3")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller2)

        val controller3 = LemmyApi.getLemmyApi(instance = "lemmy.world", version = "0.19.1")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x0.LemmyApiUniWrapper::class.java, controller3)

        val controller4 = LemmyApi.getLemmyApi(instance = "lemmy.world", version = "0.19.9")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x6.LemmyApiUniWrapper::class.java, controller4)

        val controller5 = LemmyApi.getLemmyApi(instance = "lemmy.world", version = "0.19.2-alpha")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x3.LemmyApiUniWrapper::class.java, controller5)

        val controller6 = LemmyApi.getLemmyApi(instance = "lemmy.world", version = "0.19.11")
        assertInstanceOf(it.vercruysse.lemmyapi.v0.x19.x11.LemmyApiUniWrapper::class.java, controller6)
    }
}
