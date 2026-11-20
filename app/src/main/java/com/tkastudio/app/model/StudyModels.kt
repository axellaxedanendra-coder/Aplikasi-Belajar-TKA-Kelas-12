package com.tkastudio.app.model

data class BabInfo(
    val id: String,
    val nomor: Int,
    val title: String,
    val subtitle: String,
    val summary: String
)

data class KisiTopic(
    val id: String,
    val babId: String,
    val title: String,
    val kisiDescription: String,
    val intiKonsep: String,
    val ingatCepat: List<String>,
    val codeSnippet: String,
    val codeCaption: String,
    val jebakanUjian: String
)

data class QuizQuestion(
    val id: String,
    val babId: String,
    val topicId: String,
    val nomorAsli: Int?,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class QuizPackMeta(
    val id: String,
    val title: String,
    val subtitle: String,
    val sourceLabel: String
)

data class AnswerRecord(
    val selectedIndex: Int,
    val isCorrect: Boolean
)

sealed interface AppRoute {
    data object Overview : AppRoute
    data class BabMaterial(val babId: String, val topicId: String? = null) : AppRoute
    data class QuizKisi(val babId: String? = null, val topicId: String? = null) : AppRoute
    data class QuizPack(val packId: String) : AppRoute
}
