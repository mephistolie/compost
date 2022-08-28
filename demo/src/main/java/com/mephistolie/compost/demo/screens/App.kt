package com.mephistolie.compost.demo.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.screens.group.GroupScreen
import com.mephistolie.compost.demo.screens.main.MainScreen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DemoApp() {
    MaterialTheme(
        colors = Colors(
            primary = Color(0xFF38C06E),
            primaryVariant = Color(0xFF2D9957),
            secondary = MaterialTheme.colors.secondary,
            secondaryVariant = MaterialTheme.colors.secondaryVariant,
            background = MaterialTheme.colors.background,
            surface = MaterialTheme.colors.surface,
            error = MaterialTheme.colors.error,
            onPrimary = MaterialTheme.colors.onPrimary,
            onSecondary = MaterialTheme.colors.onSecondary,
            onBackground = MaterialTheme.colors.onBackground,
            onSurface = MaterialTheme.colors.onSurface,
            onError = MaterialTheme.colors.onError,
            isLight = true,
        )
    ) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setStatusBarColor(
            color = MaterialTheme.colors.primary,
        )

        val context = LocalContext.current
        val pagerState = rememberPagerState()
        var openGroup by remember { mutableStateOf<FeatureGroup?>(null) }

        BackHandler(
            onBack = {
                if (openGroup != null) openGroup = null else (context as? Activity)?.finish()
            }
        )

        openGroup.let { group ->
            if (group == null) {
                MainScreen(pagerState = pagerState, onGroupClick = { feature -> openGroup = feature })
            } else {
                GroupScreen(group, onClose = { openGroup = null })
            }
        }
    }
}
