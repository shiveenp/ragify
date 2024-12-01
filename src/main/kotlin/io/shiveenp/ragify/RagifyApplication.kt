package io.shiveenp.ragify

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RagifyApplication

fun main(args: Array<String>) {
    runApplication<RagifyApplication>(*args)
}
