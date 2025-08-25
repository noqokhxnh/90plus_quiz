package com.noqok.a90plus_quiz.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.noqok.a90plus_quiz.ui.theme.Dark800
import com.noqok.a90plus_quiz.ui.theme.GreenStatus
import com.noqok.a90plus_quiz.ui.theme.RedStatus
import com.noqok.a90plus_quiz.ui.theme.TextHighEmphasis

@Composable
fun DailyScoreWidget() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp) // Padding ngang 24px
            .padding(top = 16.dp), // Khoảng cách 16px từ banner
        horizontalArrangement = Arrangement.Start // Căn trái
    ) {
        // Wins Pill
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Dark800, shape = RoundedCornerShape(14.dp)) // Nền #111827, bo góc 14 px
                .padding(horizontal = 12.dp, vertical = 8.dp) // Padding ngang 12 px
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Wins",
                tint = GreenStatus,
                modifier = Modifier.size(20.dp) // Icon size
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "5",
                color = GreenStatus,
                style = MaterialTheme.typography.titleLarge // Semibold 18 px
            )
        }

        Spacer(modifier = Modifier.width(10.dp)) // Khoảng cách giữa 2 pill 10-12 px

        // Losses Pill
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Dark800, shape = RoundedCornerShape(14.dp)) // Nền #111827, bo góc 14 px
                .padding(horizontal = 12.dp, vertical = 8.dp) // Padding ngang 12 px
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Losses",
                tint = RedStatus,
                modifier = Modifier.size(20.dp) // Icon size
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "2",
                color = RedStatus,
                style = MaterialTheme.typography.titleLarge // Semibold 18 px
            )
        }
    }
}