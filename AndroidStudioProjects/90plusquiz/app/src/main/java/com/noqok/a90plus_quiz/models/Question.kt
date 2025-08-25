package com.noqok.a90plus_quiz.models

data class Question(
    val playerId: Int,
    val correctAnswer: String,
    val hints: List<String>,
    val difficulty: String
)
