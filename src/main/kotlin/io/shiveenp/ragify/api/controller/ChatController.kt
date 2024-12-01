package io.shiveenp.ragify.api.controller

import io.shiveenp.ragify.api.request.QuestionRequestDto
import io.shiveenp.ragify.api.response.AnswerResponseDto
import io.shiveenp.ragify.service.chat.ChatService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/chat")
class ChatController(
    val chatService: ChatService
) {
    @PostMapping("/question", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAnswer(@RequestBody questionRequestDto: QuestionRequestDto): ResponseEntity<AnswerResponseDto> {
        val chatResponse = chatService.answerPrompt(questionRequestDto.prompt)
        return ResponseEntity.ok(AnswerResponseDto(chatResponse.answer))
    }
}
