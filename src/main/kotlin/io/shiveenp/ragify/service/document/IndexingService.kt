package io.shiveenp.ragify.service.document

import java.nio.file.Path

interface IndexingService {
    fun indexFiles(filePaths: List<Path>)
}
