package com.noqok.a90plus_quiz.activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noqok.a90plus_quiz.R
import com.noqok.a90plus_quiz.adapters.HintAdapter
import com.noqok.a90plus_quiz.app.MyApplication
import com.noqok.a90plus_quiz.models.GameState
import com.noqok.a90plus_quiz.viewmodels.GameViewModel
import com.noqok.a90plus_quiz.viewmodels.GameViewModelFactory

class GameModeActivity : ComponentActivity() {

    private lateinit var viewModel: GameViewModel
    private lateinit var hintAdapter: HintAdapter
    private lateinit var scoreTextView: TextView
    private lateinit var hintsRecyclerView: RecyclerView
    private lateinit var answerEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        // Initialize views
        scoreTextView = findViewById(R.id.scoreTextView)
        hintsRecyclerView = findViewById(R.id.hintsRecyclerView)
        answerEditText = findViewById(R.id.answerEditText)
        submitButton = findViewById(R.id.submitButton)
        progressBar = findViewById(R.id.progressBar)

        // Setup RecyclerView
        hintsRecyclerView.layoutManager = LinearLayoutManager(this)
        hintAdapter = HintAdapter()
        hintsRecyclerView.adapter = hintAdapter

        // Setup ViewModel
        val myApp = application
        if (myApp is MyApplication) {
            val apiRepository = myApp.apiRepository
            val factory = GameViewModelFactory(apiRepository)
            viewModel = ViewModelProvider(this, factory)[GameViewModel::class.java]
        }

        // Observe LiveData
        observeViewModel()

        // Set button click listener
        submitButton.setOnClickListener {
            val userAnswer = answerEditText.text.toString()
            viewModel.checkAnswer(userAnswer)
        }

        // Start the first game
        viewModel.startNewGame()
    }

    private fun observeViewModel() {
        viewModel.score.observe(this) { score ->
            scoreTextView.text = "Score: $score"
        }

        viewModel.teammateHints.observe(this) { hints ->
            hintAdapter.updateHints(hints)
        }

        viewModel.gameState.observe(this) { state ->
            updateUiForGameState(state)
        }
    }

    private fun updateUiForGameState(state: GameState) {
        progressBar.visibility = if (state == GameState.LOADING) View.VISIBLE else View.GONE
        val isPlaying = state == GameState.PLAYING
        submitButton.isEnabled = isPlaying
        answerEditText.isEnabled = isPlaying

        when (state) {
            GameState.SUCCESS -> {
                Toast.makeText(this@GameModeActivity, "Correct!", Toast.LENGTH_SHORT).show()
                answerEditText.text.clear()
                viewModel.startNewGame() // Automatically start next game
            }
            GameState.FAIL -> {
                Toast.makeText(this@GameModeActivity, "Wrong answer! Try again.", Toast.LENGTH_SHORT).show()
            }
            GameState.PLAYING -> {
                answerEditText.requestFocus()
            }
            else -> {}
        }
    }
}