package io.shiveenp.ragify.service.chat

import io.shiveenp.ragify.domain.model.ChatResponse

interface ChatService {
    fun answerPrompt(prompt: String): ChatResponse
}
