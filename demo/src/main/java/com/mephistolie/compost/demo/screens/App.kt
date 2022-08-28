package com.mephistolie.compost.demo.screens

import android.app.Activity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.withResumed
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.screens.group.GroupScreen
import com.mephistolie.compost.demo.screens.main.MainScreen

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
        val context = LocalContext.current
        var openGroup by remember { mutableStateOf<FeatureGroup?>(null) }

        BackHandler(
            onBack = {
                if (openGroup != null) openGroup = null else (context as? Activity)?.finish()
            }
        )

        openGroup.let { group ->
            if (group == null) {
                MainScreen(onGroupClick = { feature -> openGroup = feature })
            } else {
                GroupScreen(group, onClose = { openGroup = null })
            }
        }
    }
}
