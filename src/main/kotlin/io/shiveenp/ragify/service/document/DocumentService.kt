package io.shiveenp.ragify.service.document

import java.nio.file.Path

interface DocumentService {
    fun ingest(filePath: Path)
}
