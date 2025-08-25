package com.noqok.a90plus_quiz.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noqok.a90plus_quiz.navigation.Screen
import com.noqok.a90plus_quiz.ui.components.DailyScoreWidget
import com.noqok.a90plus_quiz.ui.components.GameModeCard
import com.noqok.a90plus_quiz.ui.components.NotificationBar
import com.noqok.a90plus_quiz.ui.theme.PrimaryBlue
import com.noqok.a90plus_quiz.ui.theme.Dark900
import com.noqok.a90plus_quiz.ui.theme.AccentYellow
import androidx.compose.material3.MaterialTheme
import com.noqok.a90plus_quiz.ui.theme.AccentYellow
import com.noqok.a90plus_quiz.ui.theme.PrimaryBlue
import com.noqok.a90plus_quiz.ui.theme.Dark900
import com.noqok.a90plus_quiz.ui.theme.TextHighEmphasis

import com.noqok.a90plus_quiz.R // Import R for drawable resources

data class GameMode(
    val name: String,
    val description: String,
    val isNew: Boolean,
    val route: String,
    val iconResId: Int // New field for icon resource ID
)

val gameModes = listOf(
    GameMode(
        name = "Find Football Player",
        description = "Guess the name of a football player based on the hints of other players they have played with.",
        isNew = false,
        route = Screen.GameMode1.route,
        iconResId = R.drawable.ic_launcher_foreground // Placeholder icon
    ),
    GameMode(
        name = "Football Vocabulary Game",
        description = "Daily football player crossword puzzle.",
        isNew = false,
        route = Screen.GameMode2.route,
        iconResId = R.drawable.ic_launcher_foreground // Placeholder icon
    ),
    GameMode(
        name = "Team Building",
        description = "Build a team with specific constraints.",
        isNew = true,
        route = Screen.GameMode3.route,
        iconResId = R.drawable.ic_launcher_foreground // Placeholder icon
    )
)



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        containerColor = Dark900,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                                            Text(
                        "90+",
                        style = MaterialTheme.typography.displayLarge,
                                                                                color = PrimaryBlue
                    )
                    Text(
                        " Quiz",
                        style = MaterialTheme.typography.displayLarge,
                        color = PrimaryBlue
                    )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { navController.navigate(Screen.Profile.route) },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = TextHighEmphasis
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Dark900),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp) // Height 56-64dp
                    .shadow(elevation = 4.dp, spotColor = Color.Black.copy(alpha = 0.12f)) // Shadow nhẹ
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            NotificationBar()
            DailyScoreWidget()
            Text(
                text = "Select the football game you want to play:",
                color = TextHighEmphasis,
                style = MaterialTheme.typography.headlineLarge, // H2 20–22 px, Semibold
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp) // Padding ngang 24px
                    .padding(top = 16.dp, bottom = 20.dp) // margin-top 16 px, margin-bottom 16–20 px
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp), // Padding ngang 24px
                verticalArrangement = Arrangement.spacedBy(16.dp) // Khoảng cách giữa mỗi card 16-20 px
            ) {
                items(gameModes.size) { index ->
                    val gameMode = gameModes[index]
                    GameModeCard(
                        gameName = gameMode.name,
                        description = gameMode.description,
                        isNew = gameMode.isNew,
                        iconResId = gameMode.iconResId // Pass the iconResId
                    ) {
                        navController.navigate(gameMode.route)
                    }
                }
            }
        }
    }
}
