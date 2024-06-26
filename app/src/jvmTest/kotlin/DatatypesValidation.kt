import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import kotlin.reflect.full.primaryConstructor
import kotlin.test.Test
import kotlin.test.fail

class DatatypesValidation {
    private val versions = listOf("v0/x18/x5", "v0/x19/x0", "v0/x19/x3", "v0/x19/x4")

    @Test
    fun `all datatypes that are nullable should also be optional`() {
        versions.flatMap { getClasses(this.javaClass.classLoader, "it/vercruysse/lemmyapi/$it/datatypes") }
            .forEach { clazz ->
                val kClass = clazz.kotlin
                if (kClass.isData) {
                    val primaryConstructor = kClass.primaryConstructor
                    primaryConstructor?.parameters?.forEach { parameter ->
                        if (parameter.type.isMarkedNullable && !parameter.isOptional) {
                            fail("Parameter ${parameter.name} of class ${clazz.name} is nullable but not optional")
                        }
                    }
                }
            }
    }

    @Throws(Exception::class)
    private fun getClasses(cl: ClassLoader, pack: String): List<Class<*>> {
        val dottedPackage = pack.replace("[/]".toRegex(), ".")
        val classes: MutableList<Class<*>> = ArrayList()
        val upackage = cl.getResource(pack)

        val dis = BufferedReader(InputStreamReader(upackage?.getContent() as InputStream))
        var line: String?
        while ((dis.readLine().also { line = it }) != null) {
            if (line!!.endsWith(".class")) {
                classes.add(Class.forName(dottedPackage + "." + line!!.substring(0, line!!.lastIndexOf('.'))))
            }
        }
        return classes
    }
}
