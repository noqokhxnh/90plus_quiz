package com.noqok.a90plus_quiz.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.noqok.a90plus_quiz.viewmodels.GameMode1ViewModel

@Composable
fun GameMode1Screen(
    viewModel: GameMode1ViewModel = viewModel()
) {
    val currentQuestion by viewModel.currentQuestion.collectAsState()
    val score by viewModel.score.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    var playerNameInput by remember { mutableStateOf("") }

    // Load initial question when the screen is first composed
    // TODO: Replace with actual player ID or a mechanism to get a random player ID
    if (currentQuestion == null && !loading && errorMessage == null) {
                        viewModel.loadNewQuestion() // Example player ID
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Find Football Player Game", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        if (loading) {
            CircularProgressIndicator()
            Text("Loading question...")
        } else if (errorMessage != null) {
            Text("Error: $errorMessage", color = MaterialTheme.colorScheme.error)
            Button(onClick = { viewModel.loadNewQuestion() }) {
                Text("Retry")
            }
        } else if (currentQuestion != null) {
            Text(text = "Hints: ${currentQuestion?.hints?.joinToString()}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = playerNameInput,
                onValueChange = { playerNameInput = it },
                label = { Text("Enter player name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.checkAnswer(playerNameInput)
                    playerNameInput = "" // Clear input after submission
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Answer")
            }

            Text("Score: $score", style = MaterialTheme.typography.titleLarge)
        } else {
            Text("No question loaded. Something went wrong.")
        }

        // TODO: Add more UI elements for game state, hint system, etc.
    }
}