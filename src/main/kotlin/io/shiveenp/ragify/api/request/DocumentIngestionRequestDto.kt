package io.shiveenp.ragify.api.request

import io.shiveenp.ragify.domain.model.IngestionType

data class DocumentIngestionRequestDto(
    val paths: List<String>,
    val fileTypes: String
)
