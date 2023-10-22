import pictrs.PictrsAPI

interface LemmyApiBase : PictrsAPI, OldRoutes {
    val version: String
    override var auth: String?
}

// TODO: nodeinfo
