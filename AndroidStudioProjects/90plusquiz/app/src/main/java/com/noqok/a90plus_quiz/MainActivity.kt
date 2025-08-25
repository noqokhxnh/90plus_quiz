package com.noqok.a90plus_quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.noqok.a90plus_quiz.navigation.NavGraph
import com.noqok.a90plus_quiz.ui.theme._90plusquizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _90plusquizTheme {
                NavGraph()
            }
        }
    }
}
