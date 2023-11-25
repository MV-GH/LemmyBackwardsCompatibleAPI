package it.vercruysse.lemmyapi

import it.vercruysse.lemmyapi.utils.compareVersions
import it.vercruysse.lemmyapi.utils.dropPatchVersion

/**
 * Use these flags to check if a certain feature is available on this version of Lemmy.
 */
class FeatureFlags(val version: String) {
    private val shortVersion = dropPatchVersion(version)
    private val v0x19Plus = compareVersions(shortVersion, "0.19") >= 0

    /**
     * InstanceBlock Feature added in 0.19
     *
     */
    fun instanceBlock(): Boolean = v0x19Plus

    /**
     * TOTP Rework Feature added in 0.19
     *
     * Endpoint `generateTotpSecret` + `updateTotpSecret`
     */
    fun totpRework(): Boolean = v0x19Plus

    /**
     * User Import/Export Settings Feature added in 0.19
     *
     * Endpoint `exportUserSettings` + `importUserSettings`
     */
    fun userImportExportSettings(): Boolean = v0x19Plus

    /**
     * List LoginTokens Feature added in 0.19
     */
    fun listLoginTokens(): Boolean = v0x19Plus

    /**
     * Logout, invalidate current token Feature added in 0.19
     */
    fun logout(): Boolean = v0x19Plus
}
