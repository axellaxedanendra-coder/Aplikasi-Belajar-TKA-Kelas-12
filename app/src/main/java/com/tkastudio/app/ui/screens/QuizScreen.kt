package com.tkastudio.app.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tkastudio.app.data.babsList
import com.tkastudio.app.data.getQuestionsForPack
import com.tkastudio.app.data.kisiTopicsList
import com.tkastudio.app.data.quizPacksList
import com.tkastudio.app.model.AnswerRecord
import com.tkastudio.app.model.AppRoute
import com.tkastudio.app.ui.theme.MonoColors
import kotlin.random.Random

private val LETTERS = listOf("A", "B", "C", "D", "E")

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuizScreen(
    isKisiMode: Boolean,
    packId: String,
    initialBabId: String?,
    initialTopicId: String?,
    answersByPack: Map<String, Map<String, AnswerRecord>>,
    onRecordAnswer: (packId: String, questionId: String, record: AnswerRecord) -> Unit,
    onResetPack: (packId: String, questionIds: List<String>) -> Unit,
    onNavigate: (AppRoute) -> Unit
) {
    val activePackKey = if (isKisiMode) "kisi-kisi" else packId
    val packMeta = quizPacksList.find { it.id == activePackKey } ?: quizPacksList.first()

    var selectedBab by remember { mutableStateOf(initialBabId ?: "all") }
    var selectedTopic by remember { mutableStateOf(initialTopicId ?: "all") }
    var isShuffled by remember { mutableStateOf(false) }
    var shuffleSeed by remember { mutableIntStateOf(1) }
    var showNavigator by remember { mutableStateOf(false) }
    var reviewAllMode by remember { mutableStateOf(false) }
    var currentIndex by remember { mutableIntStateOf(0) }
    var topicMenuExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(isKisiMode, packId, initialBabId, initialTopicId) {
        if (isKisiMode) {
            selectedBab = initialBabId ?: "all"
            selectedTopic = initialTopicId ?: "all"
        }
        currentIndex = 0
        reviewAllMode = false
    }

    val packAnswers = answersByPack[activePackKey] ?: emptyMap()
    val rawQuestions = remember(activePackKey) { getQuestionsForPack(activePackKey) }

    val scopedQuestions = remember(rawQuestions, isKisiMode, selectedBab, selectedTopic) {
        if (!isKisiMode) rawQuestions
        else rawQuestions.filter { q ->
            val babOk = selectedBab == "all" || q.babId == selectedBab
            val topicOk = selectedTopic == "all" || q.topicId == selectedTopic
            babOk && topicOk
        }
    }

    val activeQuestions = remember(scopedQuestions, isShuffled, shuffleSeed) {
        if (!isShuffled) scopedQuestions
        else scopedQuestions.shuffled(Random(shuffleSeed))
    }

    val wrongQuestions = remember(scopedQuestions, packAnswers) {
        scopedQuestions.filter { q ->
            val ans = packAnswers[q.id]
            ans != null && !ans.isCorrect
        }
    }

    val answeredCount = scopedQuestions.count { packAnswers.containsKey(it.id) }
    val correctCount = scopedQuestions.count { packAnswers[it.id]?.isCorrect == true }
    val incorrectCount = answeredCount - correctCount
    val accuracyPercent = if (answeredCount > 0) (correctCount * 100) / answeredCount else 0

    val safeIndex = currentIndex.coerceIn(0, (activeQuestions.size - 1).coerceAtLeast(0))
    val currentQuestion = activeQuestions.getOrNull(safeIndex)
    val currentAnswer = currentQuestion?.let { packAnswers[it.id] }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MonoColors.BgCanvas),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header & Live Stats
        item {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "${packMeta.sourceLabel} · Umpan balik instan",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = MonoColors.TextMuted
                )
                Text(
                    text = packMeta.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MonoColors.PureWhite
                )

                // Stats Bar
                Surface(
                    color = MonoColors.BgSurface,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, MonoColors.Border),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        StatChip("Terjawab", "$answeredCount/${scopedQuestions.size}")
                        StatChip("Benar", "$correctCount")
                        StatChip("Salah", "$incorrectCount")
                        StatChip("Akurasi", "$accuracyPercent%")
                    }
                }

                // Filter controls for Kisi-kisi mode
                if (isKisiMode) {
                    Surface(
                        color = MonoColors.BgSurface,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MonoColors.Border),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                FilterChipBtn(
                                    label = "Semua Bab",
                                    active = selectedBab == "all",
                                    onClick = {
                                        selectedBab = "all"
                                        selectedTopic = "all"
                                        currentIndex = 0
                                        reviewAllMode = false
                                    }
                                )
                                babsList.forEach { b ->
                                    FilterChipBtn(
                                        label = "Bab ${b.nomor}",
                                        active = selectedBab == b.id,
                                        onClick = {
                                            selectedBab = b.id
                                            selectedTopic = "all"
                                            currentIndex = 0
                                            reviewAllMode = false
                                        }
                                    )
                                }
                            }

                            val availTopics = remember(selectedBab) {
                                if (selectedBab == "all") kisiTopicsList
                                else kisiTopicsList.filter { it.babId == selectedBab }
                            }

                            Box {
                                OutlinedButton(
                                    onClick = { topicMenuExpanded = true },
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(1.dp, MonoColors.BorderStrong),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        containerColor = MonoColors.BgCanvas,
                                        contentColor = MonoColors.PureWhite
                                    ),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    val selectedLabel = if (selectedTopic == "all") {
                                        "Nomor Kisi: Semua"
                                    } else {
                                        val found = kisiTopicsList.find { it.id == selectedTopic }
                                        "Nomor Kisi: ${found?.id ?: selectedTopic} — ${found?.title ?: ""}"
                                    }
                                    Text(selectedLabel, fontSize = 12.sp)
                                }
                                DropdownMenu(
                                    expanded = topicMenuExpanded,
                                    onDismissRequest = { topicMenuExpanded = false },
                                    modifier = Modifier.background(MonoColors.BgSurface)
                                ) {
                                    DropdownMenuItem(
                                        text = { Text("Semua Nomor", color = MonoColors.PureWhite, fontSize = 13.sp) },
                                        onClick = {
                                            selectedTopic = "all"
                                            currentIndex = 0
                                            reviewAllMode = false
                                            topicMenuExpanded = false
                                        }
                                    )
                                    availTopics.forEach { t ->
                                        DropdownMenuItem(
                                            text = { Text("${t.id} — ${t.title}", color = MonoColors.PureWhite, fontSize = 13.sp) },
                                            onClick = {
                                                selectedTopic = t.id
                                                currentIndex = 0
                                                reviewAllMode = false
                                                topicMenuExpanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Action Toolbar
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChipBtn(
                        label = "Daftar Nomor (${activeQuestions.size})",
                        active = showNavigator,
                        icon = Icons.Filled.GridView,
                        onClick = { showNavigator = !showNavigator }
                    )
                    FilterChipBtn(
                        label = if (isShuffled) "Urutan Acak" else "Acak Soal",
                        active = isShuffled,
                        icon = Icons.Filled.Shuffle,
                        onClick = {
                            if (!isShuffled) shuffleSeed += 7
                            isShuffled = !isShuffled
                            currentIndex = 0
                        }
                    )
                    FilterChipBtn(
                        label = if (reviewAllMode) "Kembali ke Soal" else "Ringkasan",
                        active = reviewAllMode,
                        icon = Icons.AutoMirrored.Filled.List,
                        onClick = { reviewAllMode = !reviewAllMode }
                    )
                    if (wrongQuestions.isNotEmpty()) {
                        FilterChipBtn(
                            label = "Ulangi Salah (${wrongQuestions.size})",
                            active = true,
                            icon = Icons.Filled.Refresh,
                            onClick = {
                                onResetPack(activePackKey, wrongQuestions.map { it.id })
                                reviewAllMode = false
                                currentIndex = 0
                            }
                        )
                    }
                    if (answeredCount > 0) {
                        TextButton(
                            onClick = {
                                onResetPack(activePackKey, scopedQuestions.map { it.id })
                                reviewAllMode = false
                                currentIndex = 0
                            }
                        ) {
                            Text("Reset", color = MonoColors.TextMuted, fontSize = 12.sp)
                        }
                    }
                }

                // Progress bar
                val progFrac = if (scopedQuestions.isNotEmpty()) answeredCount.toFloat() / scopedQuestions.size else 0f
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(MonoColors.Border)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progFrac)
                            .height(5.dp)
                            .background(MonoColors.PureWhite)
                    )
                }
            }
        }

        // Navigator Grid
        if (showNavigator) {
            item {
                Surface(
                    color = MonoColors.BgSurface,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MonoColors.Border),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Putih = Benar · Tebal = Salah · Gelap = Belum",
                            fontSize = 11.sp,
                            color = MonoColors.TextMuted
                        )
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            activeQuestions.forEachIndexed { idx, q ->
                                val ans = packAnswers[q.id]
                                val isCurr = !reviewAllMode && idx == safeIndex
                                val bg = if (ans?.isCorrect == true) MonoColors.PureWhite else MonoColors.BgCanvas
                                val fg = if (ans?.isCorrect == true) MonoColors.BgCanvas else MonoColors.TextPrimary
                                val borderColor = when {
                                    isCurr -> MonoColors.PureWhite
                                    ans != null -> MonoColors.PureWhite
                                    else -> MonoColors.Border
                                }
                                val borderWidth = if (isCurr || (ans != null && !ans.isCorrect)) 2.dp else 1.dp

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(bg)
                                        .border(borderWidth, borderColor, RoundedCornerShape(6.dp))
                                        .clickable {
                                            currentIndex = idx
                                            reviewAllMode = false
                                        }
                                ) {
                                    Text(
                                        text = "${idx + 1}",
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = fg,
                                        textDecoration = if (ans != null && !ans.isCorrect) TextDecoration.LineThrough else null
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Body: Review All OR Single Question
        if (activeQuestions.isEmpty()) {
            item {
                Text(
                    text = "Tidak ada soal pada filter ini.",
                    fontSize = 14.sp,
                    color = MonoColors.TextMuted
                )
            }
        } else if (reviewAllMode) {
            item {
                Surface(
                    color = MonoColors.PureWhite,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text("RINGKASAN HASIL", fontFamily = FontFamily.Monospace, fontSize = 11.sp, color = MonoColors.TextDim)
                        Text(
                            text = "Skor $correctCount / ${scopedQuestions.size} ($accuracyPercent%)",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MonoColors.BgCanvas
                        )
                    }
                }
            }
            itemsIndexed(activeQuestions, key = { _, q -> q.id }) { idx, q ->
                val ans = packAnswers[q.id]
                Surface(
                    color = MonoColors.BgSurface,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MonoColors.Border),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Soal ${idx + 1} · Kisi ${q.topicId}", fontFamily = FontFamily.Monospace, fontSize = 11.sp, color = MonoColors.TextMuted)
                            val statusText = when {
                                ans == null -> "Belum"
                                ans.isCorrect -> "BENAR"
                                else -> "SALAH"
                            }
                            Text(statusText, fontFamily = FontFamily.Monospace, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = MonoColors.PureWhite)
                        }
                        Text(q.question, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = MonoColors.PureWhite)
                        Text(
                            text = "Kunci: ${LETTERS.getOrElse(q.correctIndex) { "?" }}. ${q.options.getOrElse(q.correctIndex) { "" }}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MonoColors.PureWhite
                        )
                        Text(
                            text = q.explanation,
                            fontSize = 12.sp,
                            color = MonoColors.TextSecondary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                                .background(MonoColors.BgCanvas)
                                .padding(10.dp)
                        )
                    }
                }
            }
        } else if (currentQuestion != null) {
            item(key = currentQuestion.id) {
                Surface(
                    color = MonoColors.BgSurface,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MonoColors.Border),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val asliText = if (currentQuestion.nomorAsli != null && !isShuffled) " · Asli #${currentQuestion.nomorAsli}" else ""
                            Text(
                                text = "Soal ${safeIndex + 1} dari ${activeQuestions.size}$asliText",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                color = MonoColors.TextMuted
                            )
                            Text(
                                text = "Materi ${currentQuestion.topicId}",
                                fontFamily = FontFamily.Monospace,
                                fontSize = 11.sp,
                                color = MonoColors.TextSecondary,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable {
                                        onNavigate(AppRoute.BabMaterial(currentQuestion.babId, currentQuestion.topicId))
                                    }
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }

                        HorizontalDivider(color = MonoColors.Border)

                        Text(
                            text = currentQuestion.question,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 24.sp,
                            color = MonoColors.PureWhite
                        )

                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            currentQuestion.options.forEachIndexed { idx, optText ->
                                val hasAnswered = currentAnswer != null
                                val isCorrectOpt = idx == currentQuestion.correctIndex
                                val isSelected = currentAnswer?.selectedIndex == idx

                                val bgColor = when {
                                    hasAnswered && isCorrectOpt -> MonoColors.PureWhite
                                    hasAnswered && isSelected && !isCorrectOpt -> MonoColors.BgCanvas
                                    else -> MonoColors.BgCanvas
                                }
                                val textColor = when {
                                    hasAnswered && isCorrectOpt -> MonoColors.BgCanvas
                                    hasAnswered && !isSelected -> MonoColors.TextDim
                                    else -> MonoColors.TextPrimary
                                }
                                val borderColor = when {
                                    hasAnswered && (isCorrectOpt || isSelected) -> MonoColors.PureWhite
                                    else -> MonoColors.Border
                                }
                                val borderStroke = if (hasAnswered && isSelected && !isCorrectOpt) 2.dp else 1.dp

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(bgColor)
                                        .border(borderStroke, borderColor, RoundedCornerShape(8.dp))
                                        .clickable(enabled = !hasAnswered) {
                                            onRecordAnswer(
                                                activePackKey,
                                                currentQuestion.id,
                                                AnswerRecord(
                                                    selectedIndex = idx,
                                                    isCorrect = idx == currentQuestion.correctIndex
                                                )
                                            )
                                        }
                                        .padding(14.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Row(
                                        modifier = Modifier.weight(1f),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Text(
                                            text = "${LETTERS.getOrElse(idx) { "?" }}.",
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (hasAnswered && isCorrectOpt) MonoColors.BorderStrong else MonoColors.TextMuted
                                        )
                                        Text(
                                            text = optText,
                                            fontSize = 14.sp,
                                            lineHeight = 20.sp,
                                            color = textColor
                                        )
                                    }

                                    if (hasAnswered && isCorrectOpt) {
                                        Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = MonoColors.BgCanvas, modifier = Modifier.size(18.dp))
                                    } else if (hasAnswered && isSelected && !isCorrectOpt) {
                                        Icon(Icons.Filled.Close, contentDescription = null, tint = MonoColors.PureWhite, modifier = Modifier.size(18.dp))
                                    }
                                }
                            }
                        }

                        // Instant Feedback Box
                        AnimatedVisibility(
                            visible = currentAnswer != null,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            currentAnswer?.let { ans ->
                                val feedbackBg = if (ans.isCorrect) MonoColors.PureWhite else MonoColors.BgCanvas
                                val feedbackTitleColor = if (ans.isCorrect) MonoColors.BgCanvas else MonoColors.PureWhite
                                val feedbackBodyColor = if (ans.isCorrect) MonoColors.BorderStrong else MonoColors.TextSecondary

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(feedbackBg)
                                        .border(if (ans.isCorrect) 1.dp else 2.dp, MonoColors.PureWhite, RoundedCornerShape(8.dp))
                                        .padding(14.dp),
                                    verticalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (ans.isCorrect) Icons.Filled.CheckCircle else Icons.Filled.Close,
                                            contentDescription = null,
                                            tint = feedbackTitleColor,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Text(
                                            text = if (ans.isCorrect) "BENAR!"
                                            else "KURANG TEPAT · Kunci: ${LETTERS.getOrElse(currentQuestion.correctIndex) { "?" }}",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = feedbackTitleColor
                                        )
                                    }
                                    Text(
                                        text = currentQuestion.explanation,
                                        fontSize = 13.sp,
                                        lineHeight = 19.sp,
                                        color = feedbackBodyColor
                                    )
                                }
                            }
                        }

                        HorizontalDivider(color = MonoColors.Border)

                        // Bottom Prev / Next
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            OutlinedButton(
                                onClick = { if (safeIndex > 0) currentIndex = safeIndex - 1 },
                                enabled = safeIndex > 0,
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(1.dp, MonoColors.BorderStrong),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = MonoColors.BgInset,
                                    contentColor = MonoColors.PureWhite
                                )
                            ) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(15.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Sebelumnya", fontSize = 12.sp)
                            }

                            Button(
                                onClick = {
                                    if (safeIndex < activeQuestions.lastIndex) {
                                        currentIndex = safeIndex + 1
                                    } else {
                                        reviewAllMode = true
                                    }
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MonoColors.PureWhite,
                                    contentColor = MonoColors.BgCanvas
                                )
                            ) {
                                Text(
                                    text = if (safeIndex < activeQuestions.lastIndex) "Soal Berikutnya" else "Ringkasan Skor",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(15.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatChip(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(label, fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = MonoColors.TextMuted)
        Text(value, fontFamily = FontFamily.Monospace, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MonoColors.PureWhite)
    }
}

@Composable
private fun FilterChipBtn(
    label: String,
    active: Boolean,
    icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(if (active) MonoColors.PureWhite else MonoColors.BgSurface)
            .border(1.dp, if (active) MonoColors.PureWhite else MonoColors.BorderStrong, RoundedCornerShape(6.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (active) MonoColors.BgCanvas else MonoColors.PureWhite,
                modifier = Modifier.size(14.dp)
            )
        }
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (active) MonoColors.BgCanvas else MonoColors.PureWhite
        )
    }
}
