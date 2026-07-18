package testingscripts

import it.vercruysse.lemmyapi.LemmyApiClient
import it.vercruysse.lemmyapi.LemmyApiOptions
import it.vercruysse.lemmyapi.LemmyInstance
import it.vercruysse.lemmyapi.datatypes.*
import it.vercruysse.lemmyapi.enums.NotificationDataType
import it.vercruysse.lemmyapi.enums.SearchType
import kotlinx.coroutines.runBlocking


fun script1() {
    runBlocking {

        val api = LemmyApiClient(options = LemmyApiOptions(userAgent = "GeneratorScripts/1.0.0"))
            .connect(LemmyInstance("voyager.lemmy.ml")).getOrThrow()
        println(api.version)
        println(api.getSite())
        println(api.getPosts(GetPosts()))

        println(api.getUnreadCounts())
        println(api.getMyUser())
        println(api.listNotifications(ListNotifications(NotificationDataType.All)))
        println(api.listLogins())
        println(api.search(Search(search_term = "test", type_ = SearchType.All)))
    }
}


fun main() {
    script1()
}
