package io.shiveenp.ragify.service.document

import org.slf4j.LoggerFactory
import org.springframework.ai.reader.tika.TikaDocumentReader
import org.springframework.ai.transformer.splitter.TextSplitter
import org.springframework.ai.transformer.splitter.TokenTextSplitter
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class DocumentServiceImpl(
    private val vectorStore: VectorStore,
) : DocumentService {
    private val logger = LoggerFactory.getLogger(DocumentServiceImpl::class.java)

    private val textSplitter: TextSplitter = TokenTextSplitter()

    override fun ingest(filePath: String) {
        logger.debug("Initializing vector store with pdf file at: $filePath")
        val pdfReader = TikaDocumentReader(filePath)
        vectorStore.apply {
            accept(textSplitter.apply(pdfReader.get()))
        }
        logger.debug("Initialized vector store with pdf file at: $filePath")
    }
}
