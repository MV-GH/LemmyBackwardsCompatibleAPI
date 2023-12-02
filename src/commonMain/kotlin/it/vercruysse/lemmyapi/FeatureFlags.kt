package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion

/**
 * Use these flags to check if a certain feature is available on this version of Lemmy.
 */
class FeatureFlags(val version: Version) {
    private val v0x19Plus =  version >= "0.19.0".toVersion()

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
