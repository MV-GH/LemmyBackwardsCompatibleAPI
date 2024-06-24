package org.example.autogenscripts

import java.io.File

const val SRC = "app/src/commonMain/kotlin/it/vercruysse/lemmyapi/"

const val HEADER = """
@Konverter
interface DatatypesMapper {
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

    val sourceMap = sourceFile.listFiles()!!.map { it.name to it }.toMap()
    var toSourceMappings = "// body mappings\n"


    targetFile.listFiles()
        ?.filter { !it.nameWithoutExtension.endsWith("Id") }
        ?.forEach {
            sourceMap.get(it.name)?.let {
                val typeName = it.nameWithoutExtension
                val isSourceExcluded = toSourceExclusion.contains(typeName)
                val isTargetExcluded = toTargetExclusion.contains(typeName)


                // If doesn't end with response its request body thus needs reverse mapping
                if (typeName.endsWith("Response") && !isSourceExcluded) {
                    tempFile.appendText("    fun toUni(d: $typeName): $targetQualifier$typeName\n")
                } else if (!isSourceExcluded && (
                        classHasAuth(it) || // 0.18 has auth
                            (bodyRequestIndicators.any { ind ->
                                typeName.startsWith(ind)
                            } && !dataTypesExceptions.contains(typeName))
                        )
                ) {
                    if (classHasAuth(it)) {
                        toSourceMappings += "    @Konvert(mappings=[Mapping(target=\"auth\", constant=\"auth\")])\n"
                    }
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

fun classHasAuth(classFile: File): Boolean {
    return classFile.readText().contains("val auth: String")
}

fun main() {
    val exclusionSrc = setOf<String>(
//        "MarkPostAsRead"
    )
    val exclusionTarget = setOf<String>(
//        "LocalUser", "MyUserInfo", "LocalSiteRateLimit"
    )
    genMapRoutes("v0/x19/x4", exclusionSrc, exclusionTarget)
}
