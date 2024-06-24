package it.vercruysse.lemmyapi

import io.github.z4kn4fein.semver.Version
import io.github.z4kn4fein.semver.toVersion
import io.github.z4kn4fein.semver.withoutSuffixes

/**
 * Use these flags to check if a certain feature is available on this version of Lemmy.
 */
@Suppress("unused")
class FeatureFlags(val version: Version) {
    private val v0x19Plus = version.withoutSuffixes() >= "0.19.0".toVersion()
    private val v0x19x2Plus = version.withoutSuffixes() >= "0.19.2".toVersion()
    private val v0x19x4Plus = version.withoutSuffixes() >= "0.19.4".toVersion()

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

    /**
     * List comment/post votes, feature added in 0.19.2
     */
    fun listAdminVotes(): Boolean = v0x19x2Plus

    /**
     * List media for admin and user, feature added in 0.19.4
     */
    fun listMedia(): Boolean = v0x19x4Plus

    /**
     * List blocked urls, feature added in 0.19.4
     */
    fun listBlockedUrls(): Boolean = v0x19x4Plus

    /**
     * Hide posts, feature added in 0.19.4
     */
    fun hidePost(): Boolean = v0x19x4Plus

    /**
     * Voting types reworked, changed in 0.19.4
     */
    fun votingTypeRework(): Boolean = v0x19x4Plus

    /**
     * Alt text field for images, feature added in 0.19.4
     */
    fun altText(): Boolean = v0x19x4Plus
}
