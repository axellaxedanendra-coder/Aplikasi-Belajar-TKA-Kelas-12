package com.tkastudio.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tkastudio.app.data.babsList
import com.tkastudio.app.data.kisiQuizQuestions
import com.tkastudio.app.data.kisiTopicsList
import com.tkastudio.app.model.AppRoute
import com.tkastudio.app.ui.theme.MonoColors

@Composable
fun MaterialScreen(
    babId: String,
    topicId: String?,
    masteredIds: Set<String>,
    onToggleMastered: (String) -> Unit,
    onNavigate: (AppRoute) -> Unit
) {
    val bab = babsList.find { it.id == babId } ?: babsList.first()
    val babTopics = kisiTopicsList.filter { it.babId == bab.id }
    val currentTopic = babTopics.find { it.id == topicId } ?: babTopics.first()

    val globalIndex = kisiTopicsList.indexOfFirst { it.id == currentTopic.id }
    val prevTopic = if (globalIndex > 0) kisiTopicsList[globalIndex - 1] else null
    val nextTopic = if (globalIndex in 0 until kisiTopicsList.lastIndex) kisiTopicsList[globalIndex + 1] else null

    val topicQuizCount = kisiQuizQuestions.count { it.topicId == currentTopic.id }
    val babQuizCount = kisiQuizQuestions.count { it.babId == bab.id }
    val isMastered = masteredIds.contains(currentTopic.id)

    val clipboard = LocalClipboardManager.current
    var copiedTopicId by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MonoColors.BgCanvas),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Bab Header + Horizontal Subtopic Tabs
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Bab ${bab.nomor} · ${bab.subtitle}",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            color = MonoColors.TextMuted
                        )
                        Text(
                            text = bab.title,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MonoColors.PureWhite
                        )
                    }
                    OutlinedButton(
                        onClick = { onNavigate(AppRoute.QuizKisi(babId = bab.id)) },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MonoColors.BorderStrong),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = MonoColors.BgSurface,
                            contentColor = MonoColors.PureWhite
                        )
                    ) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Kuis Bab ${bab.nomor} ($babQuizCount)", fontSize = 12.sp)
                    }
                }

                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(babTopics, key = { it.id }) { t ->
                        val active = t.id == currentTopic.id
                        val done = masteredIds.contains(t.id)
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (active) MonoColors.PureWhite else MonoColors.BgSurface)
                                .border(
                                    1.dp,
                                    if (active) MonoColors.PureWhite else MonoColors.Border,
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable { onNavigate(AppRoute.BabMaterial(bab.id, t.id)) }
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "${t.id} ${t.title}",
                                fontSize = 12.sp,
                                fontWeight = if (active) FontWeight.Bold else FontWeight.Medium,
                                color = if (active) MonoColors.BgCanvas else MonoColors.TextSecondary
                            )
                            if (done) {
                                Icon(
                                    imageVector = Icons.Filled.Check,
                                    contentDescription = null,
                                    tint = if (active) MonoColors.BgCanvas else MonoColors.PureWhite,
                                    modifier = Modifier.size(13.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Main Study Card
        item(key = currentTopic.id) {
            Surface(
                color = MonoColors.BgSurface,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, MonoColors.Border),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    // Topic Header + Mastery Toggle
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "Kisi-kisi ${currentTopic.id}",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            color = MonoColors.TextMuted
                        )
                        Text(
                            text = currentTopic.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MonoColors.PureWhite
                        )
                        Text(
                            text = "Target: ${currentTopic.kisiDescription}",
                            fontSize = 12.sp,
                            color = MonoColors.TextMuted
                        )
                        Button(
                            onClick = { onToggleMastered(currentTopic.id) },
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(
                                1.dp,
                                if (isMastered) MonoColors.PureWhite else MonoColors.BorderStrong
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isMastered) MonoColors.PureWhite else MonoColors.BgCanvas,
                                contentColor = if (isMastered) MonoColors.BgCanvas else MonoColors.PureWhite
                            )
                        ) {
                            Icon(Icons.Filled.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isMastered) "Sudah Paham" else "Tandai Paham",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    HorizontalDivider(color = MonoColors.Border)

                    // 1. Inti Konsep
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "INTI KONSEP",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MonoColors.TextMuted
                        )
                        Text(
                            text = currentTopic.intiKonsep,
                            fontSize = 15.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight.Medium,
                            color = MonoColors.TextPrimary
                        )
                    }

                    // 2. Ingat Cepat
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MonoColors.BgCanvas)
                            .border(1.dp, MonoColors.Border, RoundedCornerShape(8.dp))
                            .padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Filled.Lightbulb, contentDescription = null, tint = MonoColors.PureWhite, modifier = Modifier.size(16.dp))
                            Text(
                                text = "INGAT CEPAT",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MonoColors.PureWhite
                            )
                        }
                        currentTopic.ingatCepat.forEachIndexed { idx, hook ->
                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Text(
                                    text = "0${idx + 1}",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 12.sp,
                                    color = MonoColors.TextDim
                                )
                                Text(
                                    text = hook,
                                    fontSize = 13.sp,
                                    lineHeight = 19.sp,
                                    color = MonoColors.TextSecondary,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }

                    // 3. Contoh Kode Kelas
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "CONTOH KODE KELAS",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MonoColors.TextMuted
                            )
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .clickable {
                                        clipboard.setText(AnnotatedString(currentTopic.codeSnippet))
                                        copiedTopicId = currentTopic.id
                                    }
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(Icons.Filled.ContentCopy, contentDescription = null, tint = MonoColors.TextMuted, modifier = Modifier.size(14.dp))
                                Text(
                                    text = if (copiedTopicId == currentTopic.id) "Tersalin" else "Salin",
                                    fontSize = 12.sp,
                                    color = MonoColors.TextMuted
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(MonoColors.BgCode)
                                .border(1.dp, MonoColors.Border, RoundedCornerShape(8.dp))
                                .horizontalScroll(rememberScrollState())
                                .padding(14.dp)
                        ) {
                            Text(
                                text = currentTopic.codeSnippet,
                                fontFamily = FontFamily.Monospace,
                                fontSize = 12.sp,
                                lineHeight = 18.sp,
                                color = MonoColors.TextPrimary
                            )
                        }
                        Text(
                            text = currentTopic.codeCaption,
                            fontSize = 12.sp,
                            color = MonoColors.TextMuted
                        )
                    }

                    // 4. Jebakan Ujian
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MonoColors.BgCanvas)
                            .border(1.dp, MonoColors.TextSecondary, RoundedCornerShape(8.dp))
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(Icons.Filled.Warning, contentDescription = null, tint = MonoColors.PureWhite, modifier = Modifier.size(18.dp))
                        Text(
                            text = "Jebakan Ujian: ${currentTopic.jebakanUjian}",
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = MonoColors.TextPrimary
                        )
                    }

                    HorizontalDivider(color = MonoColors.Border)

                    // Direct Quiz CTA
                    Button(
                        onClick = {
                            onNavigate(AppRoute.QuizKisi(babId = bab.id, topicId = currentTopic.id))
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MonoColors.PureWhite,
                            contentColor = MonoColors.BgCanvas
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Latihan Soal ${currentTopic.id} ($topicQuizCount Soal)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // Prev / Next Footer
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (prevTopic != null) {
                    Surface(
                        color = MonoColors.BgSurface,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MonoColors.Border),
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onNavigate(AppRoute.BabMaterial(prevTopic.babId, prevTopic.id)) }
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = MonoColors.TextMuted, modifier = Modifier.size(16.dp))
                            Column {
                                Text("Sebelumnya · ${prevTopic.id}", fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = MonoColors.TextMuted)
                                Text(prevTopic.title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MonoColors.PureWhite, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            }
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }

                if (nextTopic != null) {
                    Surface(
                        color = MonoColors.BgSurface,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MonoColors.Border),
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onNavigate(AppRoute.BabMaterial(nextTopic.babId, nextTopic.id)) }
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.End
                            ) {
                                Text("Berikutnya · ${nextTopic.id}", fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = MonoColors.TextMuted)
                                Text(nextTopic.title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MonoColors.PureWhite, maxLines = 1, overflow = TextOverflow.Ellipsis)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = MonoColors.TextMuted, modifier = Modifier.size(16.dp))
                        }
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
