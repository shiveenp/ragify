package io.shiveenp.ragify.service.document

import org.springframework.stereotype.Service
import java.nio.file.Path
import java.util.concurrent.Executors

@Service
class IndexingServiceImpl(
    private val fileService: FileService,
    private val documentService: DocumentService,
) : IndexingService {
    override fun indexFiles(filePaths: List<Path>) {
        //todo: we need a place to keep track of files processed, this should probably run as a background op
        Executors.newVirtualThreadPerTaskExecutor().use { executorService ->
            fileService.getFilesPathsToIngest(filePaths).forEach { filePathToIngest ->
                executorService.submit {
                    documentService.ingest(filePathToIngest)
                }
            }
        }
    }
}
