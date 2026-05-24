package testingscripts

import io.github.z4kn4fein.semver.toVersion
import it.vercruysse.lemmyapi.LemmyApi
import it.vercruysse.lemmyapi.datatypes.GetPosts
import kotlinx.coroutines.runBlocking


fun script1() {
    runBlocking {

        val semver = "1.0.0-nightly-2026-05-23".toVersion()
        println(semver)
        val api = LemmyApi.getLemmyApi("voyager.lemmy.ml", "1.0.0")
        println(api.version)
        println(api.getSite())
        println(api.getPosts(GetPosts()))
    }
}


fun main() {
    script1()
}
