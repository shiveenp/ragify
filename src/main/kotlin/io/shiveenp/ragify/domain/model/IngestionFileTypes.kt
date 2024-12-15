package io.shiveenp.ragify.domain.model

enum class IngestionFileTypes(val fileExtensions: List<String>) {
    PDF(listOf("pdf"));

    companion object {
        fun isGlobalAllowedFileExtension(fileExtension: String) =
            entries.map { it.fileExtensions }.flatten().contains(fileExtension)
    }
}
