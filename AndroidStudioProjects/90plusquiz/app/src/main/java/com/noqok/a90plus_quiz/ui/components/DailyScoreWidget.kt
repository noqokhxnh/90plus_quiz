package com.noqok.a90plus_quiz.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.noqok.a90plus_quiz.ui.theme.*

@Composable
fun DailyScoreWidget() {
    val infiniteTransition = rememberInfiniteTransition(label = "scorePulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.02f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scorePulse"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 120.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Dark800.copy(alpha = 0.9f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            PrimaryBlue.copy(alpha = 0.1f),
                            AccentYellow.copy(alpha = 0.05f)
                        )
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Today's Performance",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.White
                    )
                    
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Trending",
                        tint = PrimaryBlue,
                        modifier = Modifier.size(24.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Stats Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem(
                        icon = Icons.Default.Check,
                        value = "5",
                        label = "Wins",
                        color = GreenStatus,
                        iconBackground = GreenStatus.copy(alpha = 0.2f)
                    )
                    
                    StatItem(
                        icon = Icons.Default.Close,
                        value = "2",
                        label = "Losses",
                        color = RedStatus,
                        iconBackground = RedStatus.copy(alpha = 0.2f)
                    )
                    
                    StatItem(
                        icon = Icons.Default.Star,
                        value = "850",
                        label = "Points",
                        color = AccentYellow,
                        iconBackground = AccentYellow.copy(alpha = 0.2f)
                    )
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                // Progress Bar
                LinearProgressIndicator(
                    progress = 0.71f, // 5 wins out of 7 total games
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = PrimaryBlue,
                    trackColor = Dark700.copy(alpha = 0.5f)
                )
                
                // Progress Text
                Text(
                    text = "Win Rate: 71%",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Composable
fun StatItem(
    icon: ImageVector,
    value: String,
    label: String,
    color: Color,
    iconBackground: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon with background
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = iconBackground,
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = color,
                modifier = Modifier.size(24.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Value
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.White
        )
        
        // Label
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.7f)
        )
    }
}