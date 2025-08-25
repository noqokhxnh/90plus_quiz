package com.noqok.a90plus_quiz.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.noqok.a90plus_quiz.ui.theme.AccentYellow
import com.noqok.a90plus_quiz.ui.theme.Dark800
import com.noqok.a90plus_quiz.ui.theme.PrimaryBlue
import com.noqok.a90plus_quiz.ui.theme.TextHighEmphasis
import com.noqok.a90plus_quiz.ui.theme.TextMediumEmphasis

@Composable
fun GameModeCard(
    gameName: String,
    description: String,
    isNew: Boolean = false,
    iconResId: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp) // min-height 160–180 px
            .shadow(elevation = 12.dp, spotColor = Color.Black.copy(alpha = 0.12f), shape = RoundedCornerShape(24.dp)) // elevation nhẹ
            .clickable(onClick = onClick), // Tương tác card: chạm vào vùng card = mở game
        shape = RoundedCornerShape(24.dp), // bo góc 24 px
        colors = CardDefaults.cardColors(containerColor = Dark800) // nền surface
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp), // Padding nội dung
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Icon minh họa
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = gameName,
                    modifier = Modifier.size(40.dp) // 32–40 px
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Card Title
                Text(
                    text = gameName,
                    style = MaterialTheme.typography.titleLarge, // 18 px, Semibold
                    color = TextHighEmphasis,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))

                // Mô tả ngắn
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium, // 14–16 px, Regular
                    color = TextMediumEmphasis,
                    maxLines = 2, // tối đa 2 dòng
                    overflow = TextOverflow.Ellipsis // auto-ellipsis
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Khu vực CTA
                Button(
                    onClick = onClick,
                    modifier = Modifier
                        .height(48.dp) // height 44–48 px
                        .widthIn(min = 120.dp), // min-width 96–120 px
                    shape = RoundedCornerShape(16.dp), // bo góc 14–16 px
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue) // Primary-Blue nền đặc
                ) {
                    Text(
                        text = "PLAY",
                        style = MaterialTheme.typography.bodyLarge, // Chữ white
                        color = TextHighEmphasis,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Badge "NEW"
            if (isNew) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = (-16).dp, y = 16.dp) // Điều chỉnh vị trí
                        .background(AccentYellow, shape = RoundedCornerShape(10.dp)) // màu vàng #F6C12A, pill bo 10 px
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "NEW",
                        style = MaterialTheme.typography.labelSmall, // chữ 11–12 px, Bold
                        color = Color.Black // Màu chữ đen cho badge NEW
                    )
                }
            }
        }
    }
}