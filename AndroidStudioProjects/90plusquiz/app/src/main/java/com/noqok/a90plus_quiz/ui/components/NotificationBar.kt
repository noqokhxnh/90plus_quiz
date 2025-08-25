package com.noqok.a90plus_quiz.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.noqok.a90plus_quiz.ui.theme.Dark700
import com.noqok.a90plus_quiz.ui.theme.Dark900Tint
import com.noqok.a90plus_quiz.ui.theme.PrimaryBlue
import com.noqok.a90plus_quiz.ui.theme.TextHighEmphasis
import com.noqok.a90plus_quiz.ui.theme.TextMediumEmphasis

@Composable
fun NotificationBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 88.dp) // Ép chiều cao tối đa 88 px
            .padding(horizontal = 24.dp) // Padding ngang 24 px
            .background(Dark900Tint, shape = RoundedCornerShape(20.dp)) // Nền #0F172A, bo góc 20 px
            .border(width = 1.dp, color = Dark700.copy(alpha = 0.6f), shape = RoundedCornerShape(20.dp)) // Viền #1F2937, opacity 60%
            .padding(horizontal = 16.dp, vertical = 12.dp) // Padding nội dung
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Refresh, // Icon mũi tên cập nhật/rocket
                    contentDescription = "Update Available",
                    tint = TextHighEmphasis,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "New update available",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium), // 16 px, Medium
                        color = TextHighEmphasis
                    )
                    TextButton(
                        onClick = { /* Handle update click */ },
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.height(IntrinsicSize.Min)
                    ) {
                        Text(
                            text = "Click here to update",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold), // 16 px, Semibold
                            color = PrimaryBlue,
                            textDecoration = TextDecoration.Underline // Có underline khi focus
                        )
                    }
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Nút "Update" (mặc định mờ) - hiện tại không có logic, chỉ là placeholder
                TextButton(onClick = { /* Handle update action */ }) {
                    Text(
                        text = "Update",
                        color = TextMediumEmphasis, // Mặc định mờ
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = { /* Handle close */ },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = TextMediumEmphasis
                    )
                }
            }
        }
    }
}