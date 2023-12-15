package utils

import it.vercruysse.lemmyapi.dto.SortType
import it.vercruysse.lemmyapi.dto.getSupportedEntries
import it.vercruysse.lemmyapi.utils.constructBaseUrl
import it.vercruysse.lemmyapi.utils.isBetweenVersions
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UtilTest {
    @Test
    fun compareBetweenVersions() {
        assertTrue(isBetweenVersions("0.0.2", "0.0.1", "0.0.3"))
        assertFalse(isBetweenVersions("0.0.3", "0.0.1", "0.0.3"))
        assertTrue(isBetweenVersions("0.0.1", "0.0.1", "0.0.3"))
        assertFalse(isBetweenVersions("0.0.1", "0.0.1", "0.0.1"))

        assertFalse(isBetweenVersions("0.0.2", "0.0.3", "0.0.3"))
        assertFalse(isBetweenVersions("1.0.2", "0.0.3", "0.0.3"))

        assertTrue(isBetweenVersions("1.0.2", "0.0.3", "2.0.1"))
    }

    @Test
    fun shouldConstructCorrectBaseUrls() {
        assertEquals("https://lemmy.ml", constructBaseUrl("lemmy.ml"))
        assertEquals("https://lemmy.ml", constructBaseUrl("lemmy.ml  "))
        assertEquals("http://localhost", constructBaseUrl("localhost"))
        assertEquals("https://lemmy.ml", constructBaseUrl("https://lemmy.ml"))
        assertEquals("https://voyager.lemmy.ml", constructBaseUrl("https://voyager.lemmy.ml"))
        assertEquals("https://voyager.lemmy.ml", constructBaseUrl("https://voyager.lemmy.ml/rando/stuff"))
        assertEquals("https://voyager.lemmy.ml", constructBaseUrl("voyager.lemmy.ml/rando/stuff"))
        assertEquals("https://voyager.lemmy.ml:8888", constructBaseUrl("voyager.lemmy.ml:8888/rando/stuff"))
        assertEquals("https://211.80.65.20", constructBaseUrl("211.80.65.20"))
        assertEquals("https://211.80.65.20:8888", constructBaseUrl("211.80.65.20:8888"))
    }

    @Test
    fun shouldIgnorePreReleaseTags() {
        val supportedEntries = getSupportedEntries<SortType>("0.19.0-rc.1")
        assertTrue { supportedEntries.contains(SortType.Scaled) }

        assertFalse { getSupportedEntries<SortType>("0.18.5").contains(SortType.Scaled) }
    }
}
