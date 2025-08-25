package com.noqok.a90plus_quiz.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.noqok.a90plus_quiz.ui.theme.*

@Composable
fun NotificationBar() {
    var isVisible by remember { mutableStateOf(true) }
    
    val slideInAnimation = rememberInfiniteTransition(label = "slideIn")
    val slideOffset by slideInAnimation.animateFloat(
        initialValue = -50f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "slideIn"
    )

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { -it },
            animationSpec = tween(500, easing = FastOutSlowInEasing)
        ) + fadeIn(animationSpec = tween(500)),
        exit = slideOutVertically(
            targetOffsetY = { -it },
            animationSpec = tween(300, easing = FastOutSlowInEasing)
        ) + fadeOut(animationSpec = tween(300))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 88.dp)
                .offset(y = slideOffset.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(0xFF0F172A),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1F2937).copy(alpha = 0.6f),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Left side with icon and text
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        // Animated icon container
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    brush = Brush.radialGradient(
                                        colors = listOf(
                                            PrimaryBlue.copy(alpha = 0.3f),
                                            PrimaryBlue.copy(alpha = 0.1f)
                                        )
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "New Update",
                                tint = PrimaryBlue,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        // Text content
                        Column {
                            Text(
                                text = "New update available — Click to update",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.SemiBold
                                ),
                                color = Color.White
                            )
                            
                            Spacer(modifier = Modifier.height(4.dp))
                            
                            Text(
                                text = "Version 2.1.0 with new features",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        }
                    }
                    
                    // Right side with buttons
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Update button
                        OutlinedButton(
                            onClick = { /* Handle update action */ },
                            modifier = Modifier.height(40.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color.White
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Download",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                            
                            Spacer(modifier = Modifier.width(6.dp))
                            
                            Text(
                                text = "Update",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.SemiBold
                                ),
                                color = Color.White
                            )
                        }
                        
                        // Close button
                        IconButton(
                            onClick = { isVisible = false },
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Dark700.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = Color.White.copy(alpha = 0.7f),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}