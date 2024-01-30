package org.example.autogenscripts

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.zip.ZipFile

const val ROOT_PATH = "app/src/commonMain/kotlin/"
const val ROOT_PACKAGE_PATH = "it/vercruysse/lemmyapi/"
const val ROOT_PACKAGE = "it.vercruysse.lemmyapi."
const val CUSTOM_DATATYPES_PACKAGE = "dto."

val filesThatShouldNotBeAdded = setOf("others.ts", "DeleteAccountResponse.ts", "PasswordResetResponse.ts", "VerifyEmailResponse.ts", "SuccessResponse.ts")
val propsThatShouldBeInt = setOf("my_vote")

fun getTypesPath(
    version: String,
    temp: Boolean = true,
) = "$ROOT_PATH$ROOT_PACKAGE_PATH$version/datatypes" + if (temp) "/temp" else ""

fun isInteger(@Suppress("UNUSED_PARAMETER") _l: String) = true

fun getDownloadLink(tag: String) = "https://github.com/LemmyNet/lemmy-js-client/archive/refs/tags/$tag.zip"

// Requires that dukat is installed https://github.com/Kotlin/dukat
// Rewrites the TS types to Kotlin types
suspend fun downloadTypes(
    version: String,
    vShort: String,
) {
    val temp = File("temp")
    temp.mkdir()

    val lemmyJsClient = File("temp", "lemmy-js.zip")

    client.get(getDownloadLink(version))
        .bodyAsChannel()
        .copyAndClose(lemmyJsClient.writeChannel())

    val dest = File(getTypesPath(vShort))

    for (typeFile in dest.listFiles() ?: emptyArray<File>()) {
        typeFile.delete()
    }
    dest.mkdirs()

    withContext(Dispatchers.IO) {
        val zip = ZipFile(lemmyJsClient)
        val path = "lemmy-js-client-$version/src/types"

        for (entry in zip.entries()) {
            if (entry.name.startsWith(path) && !entry.isDirectory) {
                val name = entry.name.substring(path.length)
                val f = File(dest, name)
                f.createNewFile()
                f.writeBytes(zip.getInputStream(entry).readAllBytes())
            }
        }

        val datatypes = File(getTypesPath(vShort, false))

        val command =
            mutableListOf(
                "cmd.exe",
                "/c",
                "dukat",
            )

        // Adds all the ts files to the command, "*.ts" does not work and causes an error
        for (f in dest.listFiles()!!) {
            if (f.name.endsWith(".ts") && f.isFile() && filesThatShouldNotBeAdded.contains(f.name).not()) {
                command.add("temp/${f.name}")
            }
        }

        val pb = ProcessBuilder(command)
        pb.directory(datatypes)
        val proc = pb.start()

        println(String(proc.inputStream.readAllBytes()))

        for (typeFile in datatypes.listFiles()!!) {
            if (typeFile.name.startsWith("lib") || !typeFile.name.contains("module")) {
                typeFile.delete()
            } else if (typeFile.name.endsWith(".kt") && typeFile.isFile()) {
                val fileName = typeFile.name.substringBefore(".")
                val f = File(datatypes, "$fileName.kt")
                f.createNewFile()

                // Add header for each file
                f.writeText(
                    """
                    package $ROOT_PACKAGE$vShort.datatypes
                    
                    """.trimIndent(),
                )

                var imports = ""

                // typealiases are not serializable
                if (!typeFile.readText().contains("typealias")) {
                    imports += "import kotlinx.serialization.Serializable\n\n@Serializable"
                }

                val lines =
                    typeFile.readText()
                        .split(Regex("\r?\n"))
                        .drop(15) // Remove weird dukat imports
                        .filter { !it.contains("definedExternally") } // Remove these weird getters and setters
                        .map { line ->
                            // Convert interface to data class
                            var k =
                                line.replace("interface ", "data class ")
                                    .replace(" {", "(")
                                    .replace("}", ")")

                            if (k.contains("?") && !k.contains("=")) {
                                k += " = null"
                            }

                            if (k.contains(":")) {
                                k += ","
                            }

                            // Better align with kotlin conventions
                            k =
                                k.replace(Regex("""\b(var)\b"""), "val")
                                    .replace(Regex("""\b(Array)\b"""), "List")

                            k =
                                if (isInteger(k)) {
                                    if(propsThatShouldBeInt.any { k.contains(it)}) {
                                        k.replace(Regex("""\b(Number)\b"""), "Int")
                                    } else {
                                        k.replace(Regex("""\b(Number)\b"""), "Long")
                                    }
                                } else {
                                    k.replace(Regex("""\b(Number)\b"""), "Float")
                                }

                            if (k.contains("my_vote")) {
                                k = k.replace(Regex("""\b(my_vote: Int\? = null)\b"""), "my_vote: Int = 0")
                            }

                            // Add the CustomDataTypes, that aren't autogenerated
                            k =
                                k.replace(Regex("listing_type: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}ListingType\n$imports"
                                    "listing_type: ListingType"
                                }
                            k =
                                when (fileName) {
                                    "SearchResponse", "Search" -> {
                                        k.replace(Regex("type_: String")) { _ ->
                                            imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}SearchType\n$imports"
                                            "type_: SearchType"
                                        }
                                    }

                                    "GetModlog" -> {
                                        k.replace(Regex("type_: String")) { _ ->
                                            imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}ModlogActionType\n$imports"
                                            "type_: ModlogActionType"
                                        }
                                    }

                                    else -> {
                                        k.replace(Regex("type_: String")) { _ ->
                                            imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}ListingType\n$imports"
                                            "type_: ListingType"
                                        }
                                    }
                                }

                            if (fileName == "GetComments" || fileName == "GetPersonMentions" || fileName == "GetReplies") {
                                k.replace(Regex("sort: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}CommentSortType\n$imports"
                                    "sort: CommentSortType"
                                }
                            } else {
                                k.replace(Regex("sort: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}SortType\n$imports"
                                    "sort: SortType"
                                }.replace(Regex("sort_type: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}SortType\n$imports"
                                    "sort_type: SortType"
                                }
                            }
                                .replace(Regex("registration_mode: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}RegistrationMode\n$imports"
                                    "registration_mode: RegistrationMode"
                                }
                                .replace(Regex("subscribed: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}SubscribedType\n$imports"
                                    "subscribed: SubscribedType"
                                }
                                .replace(Regex("feature_type: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}PostFeatureType\n$imports"
                                    "feature_type: PostFeatureType"
                                }
                                .replace(Regex("post_listing_mode: String")) { _ ->
                                    imports = "import $ROOT_PACKAGE${CUSTOM_DATATYPES_PACKAGE}PostListingMode\n$imports"
                                    "post_listing_mode: PostListingMode"
                                }
                        }

                if (imports != "") {
                    f.appendText("\n")
                    f.appendText(imports)
                }

                f.appendText(lines.joinToString("\n"))

                // Must end in a newline to pass formatter
                if (lines.last() != "" && lines.last() != "\r") {
                    f.appendText("\n")
                }

                typeFile.delete()
            }
        }

        dest.deleteRecursively()
    }
    temp.deleteRecursively()
}

suspend fun main() {
    downloadTypes("0.19.2-alpha.3", "v0x19")
}
