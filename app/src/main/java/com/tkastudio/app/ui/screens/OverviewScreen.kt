package com.tkastudio.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tkastudio.app.data.babsList
import com.tkastudio.app.data.getQuestionsForPack
import com.tkastudio.app.data.kisiTopicsList
import com.tkastudio.app.data.quizPacksList
import com.tkastudio.app.data.totalQuestionsCount
import com.tkastudio.app.model.AnswerRecord
import com.tkastudio.app.model.AppRoute
import com.tkastudio.app.ui.theme.MonoColors

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OverviewScreen(
    masteredIds: Set<String>,
    answersByPack: Map<String, Map<String, AnswerRecord>>,
    onNavigate: (AppRoute) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val normalized = searchQuery.trim().lowercase()
    val matchedTopics = remember(normalized) {
        if (normalized.isEmpty()) emptyList()
        else kisiTopicsList.filter {
            it.title.lowercase().contains(normalized) ||
                it.kisiDescription.lowercase().contains(normalized) ||
                it.intiKonsep.lowercase().contains(normalized) ||
                it.id.lowercase().contains(normalized)
        }
    }

    val masteredCount = kisiTopicsList.count { masteredIds.contains(it.id) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MonoColors.BgCanvas),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Hero
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Teknologi Kecerdasan Artifisial · 4 Bab · ${kisiTopicsList.size} Kisi-kisi · $totalQuestionsCount Soal",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = MonoColors.TextMuted
                )
                Text(
                    text = "Catatan Kilat & Latihan Kisi-kisi PSAS TKA",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 32.sp,
                    color = MonoColors.PureWhite
                )
                Text(
                    text = "Ringkasan padat langsung ke inti konsep, contoh kode asli dari notebook kelas, dan kuis dengan pembahasan instan.",
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = MonoColors.TextMuted
                )

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Button(
                        onClick = { onNavigate(AppRoute.BabMaterial("bab-1", "1.1")) },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MonoColors.PureWhite,
                            contentColor = MonoColors.BgCanvas
                        )
                    ) {
                        Text("Mulai Belajar Bab 1", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    OutlinedButton(
                        onClick = { onNavigate(AppRoute.QuizKisi()) },
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MonoColors.BorderStrong),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = MonoColors.BgSurface,
                            contentColor = MonoColors.PureWhite
                        )
                    ) {
                        Text("Uji Semua Kisi-kisi", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    }
                }

                // Search
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(
                            "Cari topik cepat (Pydantic, self, Docstring, 2.3)...",
                            fontSize = 13.sp,
                            color = MonoColors.TextDim
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = null,
                            tint = MonoColors.TextDim
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MonoColors.BgSurface,
                        unfocusedContainerColor = MonoColors.BgSurface,
                        focusedBorderColor = MonoColors.PureWhite,
                        unfocusedBorderColor = MonoColors.Border,
                        focusedTextColor = MonoColors.PureWhite,
                        unfocusedTextColor = MonoColors.PureWhite
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp)
                )

                if (normalized.isNotEmpty()) {
                    Surface(
                        color = MonoColors.BgSurface,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MonoColors.Border),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Hasil pencarian: ${matchedTopics.size} topik",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                color = MonoColors.TextMuted
                            )
                            if (matchedTopics.isEmpty()) {
                                Text(
                                    text = "Tidak ada kisi-kisi yang cocok.",
                                    fontSize = 13.sp,
                                    color = MonoColors.TextMuted
                                )
                            } else {
                                matchedTopics.forEach { t ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(MonoColors.BgCanvas)
                                            .border(1.dp, MonoColors.Border, RoundedCornerShape(6.dp))
                                            .clickable { onNavigate(AppRoute.BabMaterial(t.babId, t.id)) }
                                            .padding(12.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = "${t.id} · ${t.title}",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = MonoColors.PureWhite
                                            )
                                            Text(
                                                text = t.intiKonsep,
                                                fontSize = 12.sp,
                                                color = MonoColors.TextMuted,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                            contentDescription = null,
                                            tint = MonoColors.TextDim,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        item {
            HorizontalDivider(color = MonoColors.Border)
        }

        // Section: Materi Per Bab
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Materi Per Bab & Nomor Kisi-kisi",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MonoColors.PureWhite
                    )
                    Text(
                        text = "Tap nomor kisi-kisi untuk membaca ringkasan kilat.",
                        fontSize = 13.sp,
                        color = MonoColors.TextMuted
                    )
                }
                Text(
                    text = "$masteredCount/${kisiTopicsList.size} paham",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 12.sp,
                    color = MonoColors.TextMuted
                )
            }
        }

        babsList.forEach { bab ->
            item(key = bab.id) {
                val topics = kisiTopicsList.filter { it.babId == bab.id }
                val doneCount = topics.count { masteredIds.contains(it.id) }

                Surface(
                    color = MonoColors.BgSurface,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MonoColors.Border),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Bab ${bab.nomor}",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = MonoColors.PureWhite
                            )
                            Text(
                                text = "${bab.subtitle} · $doneCount/${topics.size} paham",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                color = MonoColors.TextMuted
                            )
                        }

                        Text(
                            text = bab.title,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = MonoColors.PureWhite
                        )
                        Text(
                            text = bab.summary,
                            fontSize = 13.sp,
                            color = MonoColors.TextMuted
                        )

                        HorizontalDivider(color = MonoColors.Border)

                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            topics.forEach { topic ->
                                val isDone = masteredIds.contains(topic.id)
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(6.dp))
                                        .clickable {
                                            onNavigate(AppRoute.BabMaterial(bab.id, topic.id))
                                        }
                                        .padding(horizontal = 8.dp, vertical = 7.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "${topic.id}  ${topic.title}",
                                        fontSize = 13.sp,
                                        color = MonoColors.TextSecondary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(1f)
                                    )
                                    if (isDone) {
                                        Icon(
                                            imageVector = Icons.Filled.Check,
                                            contentDescription = "Paham",
                                            tint = MonoColors.PureWhite,
                                            modifier = Modifier.size(15.dp)
                                        )
                                    }
                                }
                            }
                        }

                        HorizontalDivider(color = MonoColors.Border)

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Baca Bab ${bab.nomor}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MonoColors.PureWhite,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .clickable {
                                        onNavigate(AppRoute.BabMaterial(bab.id, topics.firstOrNull()?.id))
                                    }
                                    .padding(horizontal = 8.dp, vertical = 6.dp)
                            )

                            Button(
                                onClick = { onNavigate(AppRoute.QuizKisi(babId = bab.id)) },
                                shape = RoundedCornerShape(6.dp),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MonoColors.BgInset,
                                    contentColor = MonoColors.PureWhite
                                )
                            ) {
                                Text("Kuis Bab ${bab.nomor}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }
        }

        // Section: Bank Kuis Latihan
        item {
            Column(modifier = Modifier.padding(top = 6.dp)) {
                Text(
                    text = "Bank Kuis Latihan (4 Paket)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MonoColors.PureWhite
                )
                Text(
                    text = "Setiap jawaban langsung menampilkan benar/salah dan alasannya.",
                    fontSize = 13.sp,
                    color = MonoColors.TextMuted
                )
            }
        }

        quizPacksList.forEach { pack ->
            item(key = "pack_${pack.id}") {
                val qs = getQuestionsForPack(pack.id)
                val ansCount = answersByPack[pack.id]?.size ?: 0
                Surface(
                    color = MonoColors.BgSurface,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MonoColors.Border),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .clickable {
                            if (pack.id == "kisi-kisi") {
                                onNavigate(AppRoute.QuizKisi())
                            } else {
                                onNavigate(AppRoute.QuizPack(pack.id))
                            }
                        }
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "${pack.sourceLabel} · ${qs.size} soal",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                color = MonoColors.TextMuted
                            )
                            Text(
                                text = pack.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = MonoColors.PureWhite
                            )
                            Text(
                                text = pack.subtitle,
                                fontSize = 12.sp,
                                color = MonoColors.TextMuted
                            )
                            if (pack.id != "kisi-kisi") {
                                Text(
                                    text = "Terjawab: $ansCount/${qs.size}",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = MonoColors.TextMuted
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = MonoColors.PureWhite
                        )
                    }
                }
            }
        }
    }
}
