package com.noqok.a90plus_quiz.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noqok.a90plus_quiz.repositories.ApiRepository
import com.noqok.a90plus_quiz.repositories.FirebaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.noqok.a90plus_quiz.models.Question
import kotlinx.coroutines.launch

class GameMode1ViewModel(
    private val apiRepository: ApiRepository,
    private val firebaseRepository: FirebaseRepository
) : ViewModel() {

    private val _currentQuestion = MutableStateFlow<Question?>(null)
    val currentQuestion: StateFlow<Question?> = _currentQuestion

    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val topTeamIds = listOf(86, 81, 66, 64, 109, 524, 5) // Real Madrid, Barcelona, Man Utd, Liverpool, Juventus, PSG, Bayern

    // TODO: Implement logic to select a player and generate hints
    // For now, a placeholder to load a player
    fun loadNewQuestion() {
        viewModelScope.launch {
            _loading.value = true
            _errorMessage.value = null
            try {
                val randomTeamId = topTeamIds.random()
                val response = apiRepository.getTeamById(randomTeamId)

                if (response.isSuccessful && response.body() != null) {
                    val squad = response.body()!!.squad.shuffled()
                    if (squad.isNotEmpty()) {
                        val player = squad[0]
                        // TODO: Generate hints based on player data
                        val hints = listOf("Hint 1", "Hint 2", "Hint 3") // Placeholder hints
                        _currentQuestion.value = Question(
                            playerId = player.id,
                            correctAnswer = player.fullName,
                            hints = hints,
                            difficulty = "medium" // Placeholder difficulty
                        )
                    } else {
                        _errorMessage.value = "Team has no players."
                    }
                } else {
                    _errorMessage.value = "Failed to load player data."
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }

    fun checkAnswer(answer: String) {
        val question = _currentQuestion.value
        if (question != null) {
            if (answer.equals(question.correctAnswer, ignoreCase = true)) {
                _score.value += 100 // Example score
                // TODO: Logic for correct answer, next question
            } else {
                // TODO: Logic for incorrect answer, provide more hints or end game
            }
        }
    }

    // TODO: Add functions for hint system, game state management, Firebase score updates
}
