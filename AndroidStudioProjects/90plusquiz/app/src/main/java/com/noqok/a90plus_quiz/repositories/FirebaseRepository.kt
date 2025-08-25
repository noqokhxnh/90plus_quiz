package com.noqok.a90plus_quiz.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.tasks.await

class FirebaseRepository {

    private val db = FirebaseFirestore.getInstance()

    // Example: Save a user's score
    suspend fun saveUserScore(userId: String, score: Int): Boolean {
        return try {
            val userScore = hashMapOf(
                "score" to score,
                "timestamp" to System.currentTimeMillis()
            )
            db.collection("users").document(userId)
                .set(userScore, SetOptions.merge())
                .await()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    // Example: Get a user's score
    suspend fun getUserScore(userId: String): Int? {
        return try {
            val document = db.collection("users").document(userId).get().await()
            document.getLong("score")?.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    // TODO: Add more methods for game sessions, questions, etc.
}
