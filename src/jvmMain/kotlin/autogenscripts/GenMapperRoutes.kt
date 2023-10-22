package autogenscripts

import java.io.File

const val src = "src/commonMain/kotlin/"
val bodyRequestIndicators = listOf("Create", "Update", "Delete", "Edit", "Add", "Approve", "Ban", "Block", "Change", "PasswordChange", "Get", "Mark", "List", "Purge", "Save", "Register", "Login", "PasswordReset", "Verify")

const val header = """
@Konverter
interface DatatypesMapper {
"""

//  fun toV0x19(d: GetSiteResponse): v0x19.datatypes.GetSiteResponse
/**
 * Generates the mapping routes for the given source and target versions
 * @param source the source version, ex v0x18
 * @param target the target version, ex v0x19
 * @param toSourceExclusion a list of classes to exclude from the source version
 * @param toTargetExclusion a list of classes to exclude from the target version
 */
fun genMapRoutes(source: String, target: String, toSourceExclusion: Collection<String>, toTargetExclusion: Collection<String>) {
    val tempFile = File("temp", "MapperGenerator.kt")
    tempFile.createNewFile()
    tempFile.writeText(header + "\n")
    val sourceFile = File("$src$source/datatypes")
    val targetFile = File("$src$target/datatypes")

    val sourceLwr = source.replaceFirstChar { it.uppercase() }
    val targetLwr = target.replaceFirstChar { it.uppercase() }

    val sourceMap = sourceFile.listFiles()!!.map { it.name to it }.toMap()
    var toSourceMappings = "// body mappings\n"
    targetFile.listFiles()?.filter { !it.nameWithoutExtension.endsWith("Id") }?.forEach {
        sourceMap.get(it.name)?.let {
            val isSourceExcluded = toSourceExclusion.contains(it.nameWithoutExtension)
            val isTargetExcluded = toTargetExclusion.contains(it.nameWithoutExtension)

            // If doesn't end with response its request body thus needs reverse mapping
            if (it.nameWithoutExtension.endsWith("Response") && !isSourceExcluded) {
                tempFile.appendText("    fun to$targetLwr(d: ${it.nameWithoutExtension}): $target.datatypes.${it.nameWithoutExtension}\n")
            } else if (!isSourceExcluded && (classHasAuth(it) || bodyRequestIndicators.any { ind -> it.nameWithoutExtension.startsWith(ind) })) {
                if (classHasAuth(it)) {
                    toSourceMappings += "    @Konvert(mappings=[Mapping(target=\"auth\", constant=\"auth\")])\n"
                    toSourceMappings += "    fun to$sourceLwr(d: $target.datatypes.${it.nameWithoutExtension}): ${it.nameWithoutExtension}\n"
                } else {
                    toSourceMappings += "    fun to$sourceLwr(d: $target.datatypes.${it.nameWithoutExtension}): ${it.nameWithoutExtension}\n"
                }
            } else {
                if (!isTargetExcluded) {
                    tempFile.appendText("    fun to$targetLwr(d: ${it.nameWithoutExtension}): $target.datatypes.${it.nameWithoutExtension}\n")
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
 val exclusionSrc = setOf("MarkPostAsRead")
    val exclusionTarget = setOf("LocalUser", "MyUserInfo", "LocalSiteRateLimit")
    genMapRoutes("v0x18", "v0x19", exclusionSrc, exclusionTarget)
}
