package utils

import kotlin.test.Test
import kotlin.test.assertEquals


class UtilTest {

    @Test
    fun compareVersions() {
        assertEquals(-1, compareVersions("0.0.1", "0.0.2"))
        assertEquals(1, compareVersions("0.0.10", "0.0.2"))
        assertEquals(1, compareVersions("0.1.10", "0.1.2"))
        assertEquals(0, compareVersions("0.1.2", "0.1.2"))
        assertEquals(-1, compareVersions("0.1.2-alpha1", "0.1.2-beta1"))
        assertEquals(1, compareVersions("0.1.2-beta1", "0.1.2-alpha2"))
    }

    @Test
    fun compareBetweenVersions() {
        assertEquals(true, isBetweenVersions("0.0.2", "0.0.1", "0.0.3"))
        assertEquals(true, isBetweenVersions("0.0.3", "0.0.1", "0.0.3"))
        assertEquals(true, isBetweenVersions("0.0.1", "0.0.1", "0.0.3"))
        assertEquals(true, isBetweenVersions("0.0.1", "0.0.1", "0.0.1"))
        assertEquals(true, isBetweenVersions("0.0.3", "0.0.3", "0.0.3"))

        assertEquals(false, isBetweenVersions("0.0.2", "0.0.3", "0.0.3"))
        assertEquals(false, isBetweenVersions("1.0.2", "0.0.3", "0.0.3"))

        assertEquals(true, isBetweenVersions("1.0.2", "0.0.3", "2.0.1"))
    }
}
