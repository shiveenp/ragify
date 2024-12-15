package io.shiveenp.ragify.service.document

import io.shiveenp.ragify.domain.model.IngestionFileTypes
import org.springframework.stereotype.Service
import java.nio.file.Path

@Service
class FileServiceImpl : FileService {
    override fun getFilesPathsToIngest(ingestionFolders: List<Path>): List<Path> {
        return ingestionFolders.map(::getFilePathsForFolder).flatten()
    }

    private fun getFilePathsForFolder(ingestionFolder: Path): List<Path> {
        return ingestionFolder.toFile().walk().filter {
            it.isFile && IngestionFileTypes.isGlobalAllowedFileExtension(it.extension)
        }.map {
            it.toPath()
        }.toList()
    }
}
