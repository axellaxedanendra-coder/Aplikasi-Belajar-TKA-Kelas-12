package com.tkastudio.app

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tkastudio.app.data.ProgressStore
import com.tkastudio.app.model.AnswerRecord
import com.tkastudio.app.model.AppRoute
import com.tkastudio.app.ui.components.DrawerContent
import com.tkastudio.app.ui.screens.MaterialScreen
import com.tkastudio.app.ui.screens.OverviewScreen
import com.tkastudio.app.ui.screens.QuizScreen
import com.tkastudio.app.ui.theme.MonoColors
import com.tkastudio.app.ui.theme.TkaStudioTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )
        val store = ProgressStore(applicationContext)
        setContent {
            TkaStudioTheme {
                TkaStudioApp(store = store)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TkaStudioApp(store: ProgressStore) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var activeRoute by remember { mutableStateOf<AppRoute>(AppRoute.Overview) }
    var masteredIds by remember { mutableStateOf(store.loadMasteredIds()) }
    var answersByPack by remember { mutableStateOf(store.loadAnswersByPack()) }

    val navigate: (AppRoute) -> Unit = { route ->
        activeRoute = route
        scope.launch { drawerState.close() }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                activeRoute = activeRoute,
                masteredIds = masteredIds,
                answersByPack = answersByPack,
                onNavigate = navigate
            )
        }
    ) {
        Scaffold(
            containerColor = MonoColors.BgCanvas,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MonoColors.BgCanvas,
                        titleContentColor = MonoColors.PureWhite,
                        navigationIconContentColor = MonoColors.PureWhite
                    ),
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Buka navigasi")
                        }
                    },
                    title = {
                        Text(
                            text = "TKA Studio",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    actions = {
                        Button(
                            onClick = { navigate(AppRoute.QuizKisi()) },
                            shape = RoundedCornerShape(6.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MonoColors.PureWhite,
                                contentColor = MonoColors.BgCanvas
                            ),
                            modifier = Modifier.padding(end = 10.dp)
                        ) {
                            Text("Kuis Kisi", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (val route = activeRoute) {
                    is AppRoute.Overview -> {
                        OverviewScreen(
                            masteredIds = masteredIds,
                            answersByPack = answersByPack,
                            onNavigate = navigate
                        )
                    }

                    is AppRoute.BabMaterial -> {
                        MaterialScreen(
                            babId = route.babId,
                            topicId = route.topicId,
                            masteredIds = masteredIds,
                            onToggleMastered = { topicId ->
                                val next = if (masteredIds.contains(topicId)) {
                                    masteredIds - topicId
                                } else {
                                    masteredIds + topicId
                                }
                                masteredIds = next
                                store.saveMasteredIds(next)
                            },
                            onNavigate = navigate
                        )
                    }

                    is AppRoute.QuizKisi -> {
                        QuizScreen(
                            isKisiMode = true,
                            packId = "kisi-kisi",
                            initialBabId = route.babId,
                            initialTopicId = route.topicId,
                            answersByPack = answersByPack,
                            onRecordAnswer = { pId, qId, rec ->
                                val currentPack = answersByPack[pId]?.toMutableMap() ?: mutableMapOf()
                                currentPack[qId] = rec
                                val next = answersByPack.toMutableMap().apply { put(pId, currentPack) }
                                answersByPack = next
                                store.saveAnswersByPack(next)
                            },
                            onResetPack = { pId, qIds ->
                                val currentPack = (answersByPack[pId] ?: emptyMap())
                                    .filterKeys { !qIds.contains(it) }
                                val next = answersByPack.toMutableMap().apply { put(pId, currentPack) }
                                answersByPack = next
                                store.saveAnswersByPack(next)
                            },
                            onNavigate = navigate
                        )
                    }

                    is AppRoute.QuizPack -> {
                        QuizScreen(
                            isKisiMode = false,
                            packId = route.packId,
                            initialBabId = null,
                            initialTopicId = null,
                            answersByPack = answersByPack,
                            onRecordAnswer = { pId, qId, rec ->
                                val currentPack = answersByPack[pId]?.toMutableMap() ?: mutableMapOf()
                                currentPack[qId] = rec
                                val next = answersByPack.toMutableMap().apply { put(pId, currentPack) }
                                answersByPack = next
                                store.saveAnswersByPack(next)
                            },
                            onResetPack = { pId, qIds ->
                                val currentPack = (answersByPack[pId] ?: emptyMap())
                                    .filterKeys { !qIds.contains(it) }
                                val next = answersByPack.toMutableMap().apply { put(pId, currentPack) }
                                answersByPack = next
                                store.saveAnswersByPack(next)
                            },
                            onNavigate = navigate
                        )
                    }
                }
            }
        }
    }
}
