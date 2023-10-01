import pictrs.PictrsService
import pictrs.datatypes.UploadImage
import java.io.File

suspend fun main() {
    val api = PictrsService(getKtor("https://lemmy.one"))

    println(
        api.uploadImage(
            UploadImage(
                auth = null,
                images = listOf(
                    File("temp", "test4.jpg").readBytes(),
                    //  File("temp", "test3.jpg").readBytes()
                ),
            ),
        ),
    )
}
