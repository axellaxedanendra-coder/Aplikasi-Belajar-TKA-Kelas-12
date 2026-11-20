package com.tkastudio.app.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tkastudio.app.data.babsList
import com.tkastudio.app.data.getQuestionsForPack
import com.tkastudio.app.data.kisiTopicsList
import com.tkastudio.app.data.quizPacksList
import com.tkastudio.app.model.AnswerRecord
import com.tkastudio.app.model.AppRoute
import com.tkastudio.app.ui.theme.MonoColors

@Composable
fun DrawerContent(
    activeRoute: AppRoute,
    masteredIds: Set<String>,
    answersByPack: Map<String, Map<String, AnswerRecord>>,
    onNavigate: (AppRoute) -> Unit
) {
    // All Bab dropdowns default to CLOSED (false)
    val expandedBabs = remember { mutableStateMapOf<String, Boolean>() }
    val masteredCount = kisiTopicsList.count { masteredIds.contains(it.id) }
    val totalTopics = kisiTopicsList.size
    val percent = if (totalTopics > 0) (masteredCount * 100) / totalTopics else 0

    ModalDrawerSheet(
        drawerContainerColor = MonoColors.BgDrawer,
        drawerContentColor = MonoColors.TextPrimary,
        modifier = Modifier.width(300.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(MonoColors.BgDrawer)
        ) {
            // Brand Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigate(AppRoute.Overview) }
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Text(
                    text = "TKA Studio",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MonoColors.PureWhite
                )
                Text(
                    text = "PSAS · Python & Gemini AI",
                    fontSize = 12.sp,
                    color = MonoColors.TextMuted
                )
            }

            HorizontalDivider(color = MonoColors.Border)

            // Mastery Meter
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MonoColors.BgCanvas.copy(alpha = 0.6f))
                    .padding(horizontal = 20.dp, vertical = 14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Penguasaan Kisi-kisi",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = MonoColors.TextSecondary
                    )
                    Text(
                        text = "$masteredCount/$totalTopics ($percent%)",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MonoColors.PureWhite
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(999.dp))
                        .background(MonoColors.Border)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(percent / 100f)
                            .fillMaxHeight()
                            .background(MonoColors.PureWhite)
                    )
                }
            }

            HorizontalDivider(color = MonoColors.Border)

            // Scrollable Navigation
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                DrawerNavButton(
                    label = "Peta Kisi-kisi",
                    trailing = null,
                    isActive = activeRoute is AppRoute.Overview,
                    onClick = { onNavigate(AppRoute.Overview) }
                )

                // Materi Per Bab
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "Materi Per Bab",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MonoColors.TextDim,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )

                    babsList.forEach { bab ->
                        val topics = kisiTopicsList.filter { it.babId == bab.id }
                        val babMastered = topics.count { masteredIds.contains(it.id) }
                        val isExpanded = expandedBabs[bab.id] == true
                        val isBabActive = activeRoute is AppRoute.BabMaterial && activeRoute.babId == bab.id
                        val chevronRotation by animateFloatAsState(
                            targetValue = if (isExpanded) 180f else 0f,
                            label = "chevron"
                        )

                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isBabActive) MonoColors.PureWhite else MonoColors.BgDrawer
                                        )
                                        .clickable {
                                            expandedBabs[bab.id] = true
                                            onNavigate(AppRoute.BabMaterial(bab.id, topics.firstOrNull()?.id))
                                        }
                                        .padding(horizontal = 12.dp, vertical = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Bab ${bab.nomor}. ${bab.title}",
                                        fontSize = 13.sp,
                                        fontWeight = if (isBabActive) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isBabActive) MonoColors.BgCanvas else MonoColors.TextPrimary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.weight(1f)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "$babMastered/${topics.size}",
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 11.sp,
                                        color = if (isBabActive) MonoColors.BorderStrong else MonoColors.TextDim
                                    )
                                }

                                IconButton(
                                    onClick = { expandedBabs[bab.id] = !isExpanded },
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.KeyboardArrowDown,
                                        contentDescription = "Buka daftar Bab ${bab.nomor}",
                                        tint = MonoColors.TextMuted,
                                        modifier = Modifier
                                            .size(18.dp)
                                            .rotate(chevronRotation)
                                    )
                                }
                            }

                            AnimatedVisibility(
                                visible = isExpanded,
                                enter = expandVertically() + fadeIn(),
                                exit = shrinkVertically() + fadeOut()
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(start = 14.dp, top = 4.dp)
                                        .border(1.dp, MonoColors.Border, RoundedCornerShape(6.dp))
                                        .padding(6.dp),
                                    verticalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    topics.forEach { topic ->
                                        val isTopicActive = activeRoute is AppRoute.BabMaterial &&
                                            activeRoute.babId == bab.id &&
                                            (activeRoute.topicId ?: topics.first().id) == topic.id
                                        val isDone = masteredIds.contains(topic.id)

                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(
                                                    if (isTopicActive) MonoColors.Border else MonoColors.BgDrawer
                                                )
                                                .clickable {
                                                    onNavigate(AppRoute.BabMaterial(bab.id, topic.id))
                                                }
                                                .padding(horizontal = 10.dp, vertical = 7.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "${topic.id}  ${topic.title}",
                                                fontSize = 12.sp,
                                                fontWeight = if (isTopicActive) FontWeight.SemiBold else FontWeight.Normal,
                                                color = if (isTopicActive) MonoColors.PureWhite else MonoColors.TextMuted,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
                                                modifier = Modifier.weight(1f)
                                            )
                                            if (isDone) {
                                                Icon(
                                                    imageVector = Icons.Filled.Check,
                                                    contentDescription = "Sudah paham",
                                                    tint = MonoColors.PureWhite,
                                                    modifier = Modifier.size(14.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Kuis Per Kisi-kisi
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "Kuis Per Kisi-kisi",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MonoColors.TextDim,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    val kisiCount = getQuestionsForPack("kisi-kisi").size
                    DrawerNavButton(
                        label = "Kuis Bab & Nomor Kisi",
                        trailing = "$kisiCount soal",
                        isActive = activeRoute is AppRoute.QuizKisi,
                        onClick = { onNavigate(AppRoute.QuizKisi()) }
                    )
                }

                // 3 Paket Kuis Latihan
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "3 Paket Kuis Latihan",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MonoColors.TextDim,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    quizPacksList.filter { it.id != "kisi-kisi" }.forEach { pack ->
                        val qs = getQuestionsForPack(pack.id)
                        val ansCount = answersByPack[pack.id]?.size ?: 0
                        val isActive = activeRoute is AppRoute.QuizPack && activeRoute.packId == pack.id
                        DrawerNavButton(
                            label = pack.title,
                            trailing = "$ansCount/${qs.size}",
                            isActive = isActive,
                            onClick = { onNavigate(AppRoute.QuizPack(pack.id)) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DrawerNavButton(
    label: String,
    trailing: String?,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(if (isActive) MonoColors.PureWhite else MonoColors.BgDrawer)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = if (isActive) FontWeight.Bold else FontWeight.Medium,
            color = if (isActive) MonoColors.BgCanvas else MonoColors.TextPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        if (trailing != null) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = trailing,
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                color = if (isActive) MonoColors.BorderStrong else MonoColors.TextDim
            )
        }
    }
}
