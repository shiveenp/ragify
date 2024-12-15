package io.shiveenp.ragify.api.controller

import io.shiveenp.ragify.api.request.DocumentIngestionRequestDto
import io.shiveenp.ragify.service.document.DocumentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Paths

@RestController
@RequestMapping("/v1/index")
class IndexingController(
    private val documentService: DocumentService
) {
    @PostMapping("/documents")
    fun index(@RequestBody documentIngestionRequestDto: DocumentIngestionRequestDto): ResponseEntity<Nothing> {
        documentService.ingest(documentIngestionRequestDto.folderPath.let { Paths.get(it) })
        return ResponseEntity.ok().build()
    }
}
