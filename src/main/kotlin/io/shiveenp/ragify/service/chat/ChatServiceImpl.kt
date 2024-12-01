package io.shiveenp.ragify.service.chat

import io.shiveenp.ragify.domain.model.ChatResponse
import io.shiveenp.ragify.service.document.DocumentService
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class ChatServiceImpl(
    chatClientBuilder: ChatClient.Builder,
    private val documentService: DocumentService,
    vectorStore: VectorStore,
) : ChatService {

    private val chatClient = chatClientBuilder
        .defaultAdvisors(QuestionAnswerAdvisor(vectorStore))
        .build()

    override fun answerPrompt(prompt: String): ChatResponse {
        documentService.ingest("classpath:/docs/shiveens-family.pdf")
        return ChatResponse(
            answer = chatClient
                .prompt()
                .system(GLOBAL_DEFAULT_SYSTEM_PROMPT_GUIDANCE)
                .user(prompt)
                .call()
                .content() ?: ""
        )
    }

    companion object {
        val GLOBAL_DEFAULT_SYSTEM_PROMPT_GUIDANCE = """
            You are a helpful AI assistant that helps people find information.
            Your name is Jeff
            You should reply to the user's request with your name and also in the style of a human being.
            You always attempt to answer the user's question in a polite and friendly manner.'
            You should always answer the question if the answer is not completely wrong even if you don't have prior information.
            Don't mention your name or introduce yourself after the first prompt unless specifically requested.
             Be concise in your response but not too short either.
        """.trimIndent()
    }
}
