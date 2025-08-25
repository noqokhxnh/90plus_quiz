package com.noqok.a90plus_quiz.models

data class Player(
    val id: Int,
    val fullName: String,
    val position: String,
    val nationality: String,
    val currentClub: String,
    val formerClubs: List<String>,
    val imageUrl: String,
    val teammates: List<String> // This will be populated based on API data
)
