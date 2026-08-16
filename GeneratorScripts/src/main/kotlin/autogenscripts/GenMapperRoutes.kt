package autogenscripts

import java.io.File

const val SRC = "app/src/commonMain/kotlin/it/vercruysse/lemmyapi/"

const val HEADER = """
@Konverter
internal interface MapperGenerator {
"""


/**
 * Generates the mapping routes for the given source and target versions
 * @param source the source version, ex v0x18
 * @param toSourceExclusion a list of classes to exclude from the source version
 * @param toTargetExclusion a list of classes to exclude from the target version
 */
fun genMapRoutes(
    source: String,
    toSourceExclusion: Collection<String>,
    toTargetExclusion: Collection<String>,
) {
    val tempFile = File("temp", "MapperGenerator.kt")
    tempFile.createNewFile()
    tempFile.writeText(HEADER + "\n")
    val sourceFile = File("$SRC$source/datatypes")
    val targetFile = File("${SRC}datatypes")
    val targetQualifier = "it.vercruysse.lemmyapi.datatypes."

    val sourceMap = sourceFile.listFiles()!!.associate { it.name to it }
    var toSourceMappings = "// body mappings\n"


    targetFile.listFiles()
        ?.filter { !it.nameWithoutExtension.endsWith("Id") }
        ?.forEach {
            sourceMap.get(it.name)?.let { file ->
                val typeName = file.nameWithoutExtension
                val isSourceExcluded = toSourceExclusion.contains(typeName)
                val isTargetExcluded = toTargetExclusion.contains(typeName)

                if(shouldSkipFile(file)) {
                    return@forEach
                }

                // If doesn't end with response its request body thus needs reverse mapping
                if (typeName.endsWith("Response") && !isSourceExcluded) {
                    tempFile.appendText("    fun toUni(d: $typeName): $targetQualifier$typeName\n")
                } else if (!isSourceExcluded && (
                            (bodyRequestIndicators.any { ind ->   typeName.startsWith(ind)
                            } && !dataTypesExceptions.contains(typeName))
                        )
                ) {
                    toSourceMappings += "    fun fromUni(d: $targetQualifier$typeName): $typeName\n"
                } else {
                    if (!isTargetExcluded) {
                        tempFile.appendText(
                            "    fun toUni(d: $typeName): $targetQualifier$typeName\n",
                        )
                    }
                }
            }
        }

    tempFile.appendText("$toSourceMappings}\n")
}

// 0.18 has auth
fun classHasAuth(classFile: File): Boolean {
    return classFile.readText().contains("val auth: String")
}

fun shouldSkipFile(classFile: File) = classHasTypeAlias(classFile) || classHasInterface(classFile)

fun classHasTypeAlias(classFile: File): Boolean {
    return classFile.readText().contains("typealias ")
}

fun classHasInterface(classFile: File): Boolean {
    return classFile.readText().contains("interface ")
}

fun main() {
    val exclusionSrc = setOf<String>(
        "PagedResponse"
    )
    val exclusionTarget = setOf<String>(
        "PagedResponse"
//        "LocalUser", "MyUserInfo", "LocalSiteRateLimit"
    )
    genMapRoutes("v1/x0/x0", exclusionSrc, exclusionTarget)
}
