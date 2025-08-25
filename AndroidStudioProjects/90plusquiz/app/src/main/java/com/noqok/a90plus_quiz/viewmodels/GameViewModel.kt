package com.noqok.a90plus_quiz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noqok.a90plus_quiz.models.GameState
import com.noqok.a90plus_quiz.models.Player
import com.noqok.a90plus_quiz.repositories.ApiRepository
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    private val _targetPlayer = MutableLiveData<Player>()
    val targetPlayer: LiveData<Player> = _targetPlayer

    private val _teammateHints = MutableLiveData<List<Player>>()
    val teammateHints: LiveData<List<Player>> = _teammateHints

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _gameState = MutableLiveData<GameState>()
    val gameState: LiveData<GameState> = _gameState

    private val topTeamIds = listOf(86, 81, 66, 64, 109, 524, 5) // Real Madrid, Barcelona, Man Utd, Liverpool, Juventus, PSG, Bayern

    fun startNewGame() {
        viewModelScope.launch {
            _gameState.value = GameState.LOADING
            try {
                val randomTeamId = topTeamIds.random()
                val response = apiRepository.getTeamById(randomTeamId)

                if (response.isSuccessful && response.body() != null) {
                    val squad = response.body()!!.squad.shuffled()
                    if (squad.size >= 5) {
                        _targetPlayer.value = squad[0]
                        _teammateHints.value = squad.subList(1, 5)
                        _gameState.value = GameState.PLAYING
                    } else {
                        _gameState.value = GameState.FAIL // Not enough players in the squad
                    }
                } else {
                    _gameState.value = GameState.FAIL // API call failed
                }
            } catch (e: Exception) {
                _gameState.value = GameState.FAIL // Network or other error
            }
        }
    }

    fun checkAnswer(userAnswer: String) {
        val target = _targetPlayer.value
        if (target == null || userAnswer.isBlank()) {
            return
        }

        if (userAnswer.trim().equals(target.fullName, ignoreCase = true)) {
            _gameState.value = GameState.SUCCESS
            _score.value = (_score.value ?: 0) + 10
        } else {
            _gameState.value = GameState.FAIL
        }
    }
}
