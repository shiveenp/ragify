package io.shiveenp.ragify.service.document

import java.nio.file.Path

interface FileService {
    fun getFilesPathsToIngest(ingestionFolders: List<Path>): List<Path>
}
