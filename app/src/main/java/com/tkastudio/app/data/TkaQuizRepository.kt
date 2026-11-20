package com.tkastudio.app.data

import com.tkastudio.app.model.QuizPackMeta
import com.tkastudio.app.model.QuizQuestion

val quizPacksList: List<QuizPackMeta> = listOf(
    QuizPackMeta(
        id = "kisi-kisi",
        title = "Kuis Per Bab & Kisi-kisi",
        subtitle = "Uji pemahaman per bab atau per nomor kisi-kisi",
        sourceLabel = "Kisi-kisi Resmi & Form TKA"
    ),
    QuizPackMeta(
        id = "part-1",
        title = "Kuis Latihan Part 1",
        subtitle = "46 Soal · Kasir OOP, Pydantic & Tool Calling",
        sourceLabel = "Paket 1 (Soal 1–46)"
    ),
    QuizPackMeta(
        id = "part-2",
        title = "Kuis Latihan Part 2",
        subtitle = "45 Soal · Multi-Agent Router, Chat & JSON",
        sourceLabel = "Paket 2 (Soal 1–45)"
    ),
    QuizPackMeta(
        id = "part-3",
        title = "Kuis Latihan Part 3",
        subtitle = "45 Soal · Wayground PSAS TKA Part 3",
        sourceLabel = "Paket 3 (Soal 1–45)"
    )
)

fun getQuestionsForPack(packId: String): List<QuizQuestion> = when (packId) {
    "kisi-kisi" -> kisiQuizQuestions
    "part-1" -> quizPart1Questions
    "part-2" -> quizPart2Questions
    "part-3" -> quizPart3Questions
    else -> emptyList()
}

val totalQuestionsCount: Int =
    kisiQuizQuestions.size + quizPart1Questions.size + quizPart2Questions.size + quizPart3Questions.size
