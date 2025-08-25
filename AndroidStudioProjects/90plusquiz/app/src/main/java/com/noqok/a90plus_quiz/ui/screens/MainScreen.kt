package com.noqok.a90plus_quiz.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.noqok.a90plus_quiz.navigation.Screen
import com.noqok.a90plus_quiz.ui.components.DailyScoreWidget
import com.noqok.a90plus_quiz.ui.components.NotificationBar
import com.noqok.a90plus_quiz.ui.theme.*
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.graphics.drawscope.Fill

data class GameMode(
    val name: String,
    val description: String,
    val isNew: Boolean,
    val route: String,
    val icon: ImageVector,
    val gradient: List<Color>,
    val difficulty: String
)

val gameModes = listOf(
    GameMode(
        name = "Find Football Player",
        description = "Guess the name of a football player based on teammate hints. Use fewer hints for higher scores!",
        isNew = false,
        route = Screen.GameMode1.route,
        icon = Icons.Default.Search,
        gradient = listOf(PrimaryBlue, PrimaryBlueDark),
        difficulty = "Medium"
    ),
    GameMode(
        name = "Football Vocabulary",
        description = "Daily football player crossword puzzle. 6 guesses to find the mystery player!",
        isNew = false,
        route = Screen.GameMode2.route,
        icon = Icons.Default.Info,
        gradient = listOf(AccentYellow, AccentYellowDark),
        difficulty = "Hard"
    ),
    GameMode(
        name = "Team Building",
        description = "Build the ultimate team with specific formations and club constraints!",
        isNew = true,
        route = Screen.GameMode3.route,
        icon = Icons.Default.Info,
        gradient = listOf(SuccessGreen, SuccessGreenDark),
        difficulty = "Easy"
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Scaffold(
        containerColor = Color.Transparent,
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
                            style = MaterialTheme.typography.displayLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = PrimaryBlue
                        )
                        Text(
                            " Quiz",
                            style = MaterialTheme.typography.displayLarge.copy(
                                fontWeight = FontWeight.Normal
                            ),
                            color = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { navController.navigate(Screen.Profile.route) },
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = Dark800.copy(alpha = 0.8f),
                                shape = RoundedCornerShape(12.dp)
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Background gradient
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Dark900,
                                Dark800,
                                Dark900.copy(alpha = 0.8f)
                            )
                        )
                    )
            )
            
            // Floating football elements
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.1f)
            ) {
                drawCircle(
                    color = PrimaryBlue,
                    radius = 100f,
                    center = androidx.compose.ui.geometry.Offset(100f, 200f)
                )
                drawCircle(
                    color = AccentYellow,
                    radius = 60f,
                    center = androidx.compose.ui.geometry.Offset(300f, 400f)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                
                // Hero Section
                HeroSection(pulseScale)
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Notification Bar
                NotificationBar()

                Spacer(modifier = Modifier.height(16.dp))

                // Stats pills (Wins / Losses)
                StatsPills(wins = 5, losses = 2)
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Daily Score Widget
                DailyScoreWidget()
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // Game Modes Section
                GameModesSection(navController)
            }
        }
    }
}

@Composable
private fun Pill(text: String, color: Color, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Dark800, shape = RoundedCornerShape(14.dp))
            .border(1.dp, Dark700.copy(alpha = 0.6f), RoundedCornerShape(14.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, color = color, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold))
    }
}

@Composable
fun StatsPills(wins: Int, losses: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
        Pill(text = "$wins", color = SuccessGreen, icon = Icons.Default.Check)
        Pill(text = "$losses", color = RedStatus, icon = Icons.Default.Close)
    }
}

@Composable
fun HeroSection(pulseScale: Float) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(184.dp)
            .scale(pulseScale),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            PrimaryBlue.copy(alpha = 0.8f),
                            AccentYellow.copy(alpha = 0.6f)
                        )
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Football",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Welcome to 90+ Quiz!",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Test your football knowledge with our exciting game modes",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun GameModesSection(navController: NavController) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Select the football game you want to play:",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(0.85f),
                textAlign = TextAlign.Center
            )
        }
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(gameModes) { index, gameMode ->
                AnimatedVisibility(
                    visible = true,
                    enter = slideInVertically(
                        initialOffsetY = { it * (index + 1) },
                        animationSpec = tween(
                            durationMillis = 600 + (index * 100),
                            easing = FastOutSlowInEasing
                        )
                    ) + fadeIn(
                        animationSpec = tween(800 + (index * 100))
                    )
                ) {
                    EnhancedGameModeCard(
                        gameMode = gameMode,
                        onClick = { navController.navigate(gameMode.route) }
                    )
                }
            }
        }
    }
}

@Composable
fun EnhancedGameModeCard(
    gameMode: GameMode,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 168.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Dark800.copy(alpha = 0.9f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Background gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                gameMode.gradient[0].copy(alpha = 0.1f),
                                gameMode.gradient[1].copy(alpha = 0.05f)
                            ),
                            start = androidx.compose.ui.geometry.Offset(0f, 0f),
                            end = androidx.compose.ui.geometry.Offset(1f, 1f)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
            )
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    // Icon with background
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = gameMode.gradient
                                ),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = gameMode.icon,
                            contentDescription = gameMode.name,
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    
                    // Difficulty badge
                    Box(
                        modifier = Modifier
                            .background(
                                color = when (gameMode.difficulty) {
                                    "Easy" -> SuccessGreen
                                    "Medium" -> AccentYellow
                                    "Hard" -> RedStatus
                                    else -> PrimaryBlue
                                },
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = gameMode.difficulty,
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color.White
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Game mode info
                Column {
                    Text(
                        text = gameMode.name,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = gameMode.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f),
                        lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.2f
                    )
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                
                // Play button
                Button(
                    onClick = onClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = gameMode.gradient[0]
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Text(
                        text = "PLAY NOW",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White,
                        maxLines = 1
                    )
                }
            }
            
            // NEW badge
            if (gameMode.isNew) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-12).dp, y = 12.dp)
                        .background(
                            color = AccentYellow,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "NEW",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black
                    )
                }
            }
        }
    }
}
