import pictrs.PictrsAPI

interface LemmyApiBase : PictrsAPI {
    val version: String
    override var auth: String?
}

// TODO: nodeinfo
