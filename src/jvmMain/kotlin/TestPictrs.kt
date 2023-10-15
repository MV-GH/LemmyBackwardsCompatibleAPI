interface k {
    var h: String?

    fun printH(): String
}

open class A(override var h: String?) : k {
    override fun printH(): String {
        return h ?: "null"
    }
}

class B(override var h: String?) : A(h)

fun main() {
//    val api = PictrsService(getKtor("https://lemmy.one"), false)
//
//    println(
//        api.uploadImage(
//            UploadImage(
//                auth = "",
//                images = listOf(
//                    File("temp", "test4.jpg").readBytes(),
//                    //  File("temp", "test3.jpg").readBytes()
//                ),
//            ),
//        ),
//    )

    val b = B("test")

    println(b.printH())

    b.h = "cancer"

    println(b.printH())
}
