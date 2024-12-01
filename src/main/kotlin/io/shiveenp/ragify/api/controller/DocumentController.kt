package io.shiveenp.ragify.api.controller

import io.shiveenp.ragify.api.request.DocumentIngestionRequestDto
import io.shiveenp.ragify.service.document.DocumentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/document")
class DocumentController(
    private val documentService: DocumentService
) {

    @PostMapping("/ingest")
    fun ingestDocuments(@RequestBody documentIngestionRequestDto: DocumentIngestionRequestDto): ResponseEntity<Nothing> {
        documentService.ingest(documentIngestionRequestDto.paths.first())
        return ResponseEntity.ok().build()
    }
}
