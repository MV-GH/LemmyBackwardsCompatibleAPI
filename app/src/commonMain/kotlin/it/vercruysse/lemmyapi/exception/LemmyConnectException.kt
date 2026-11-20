package it.vercruysse.lemmyapi.exception

import it.vercruysse.lemmyapi.LemmyVersion
import it.vercruysse.lemmyapi.nodeinfo.NodeInfo

sealed class LemmyConnectException(message: String, cause: Throwable? = null) : Exception(message, cause) {

    /** The NodeInfo document could not be loaded or read; [cause] holds the transport or parsing failure. */
    class NodeInfoUnavailable(cause: Throwable) :
        LemmyConnectException("Could not load NodeInfo: ${cause.message ?: cause::class.simpleName}", cause)

    /** The instance runs some other software than Lemmy, as named in [nodeInfo]. */
    class NotLemmy(val nodeInfo: NodeInfo) :
        LemmyConnectException("Not a Lemmy instance: ${nodeInfo.software.name} ${nodeInfo.software.version}")

    /** The instance reports a version that is not a readable version number. */
    class InvalidVersion(val rawVersion: String, cause: Throwable? = null) :
        LemmyConnectException("Unreadable Lemmy version: $rawVersion", cause)

    /** The instance runs a Lemmy version this library has no implementation for, under the configured version policy. */
    class UnsupportedVersion(val version: LemmyVersion) :
        LemmyConnectException("Unsupported Lemmy version: $version")
}
