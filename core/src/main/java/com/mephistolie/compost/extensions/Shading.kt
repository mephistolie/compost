package com.mephistolie.compost.extensions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BoxScope.Shading(
    isVisible: Boolean,
    color: Color = Color.Black.copy(alpha = 0.2F),
) =
    AnimatedVisibility(
        visible = isVisible,
        modifier = Modifier.matchParentSize(),
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Box(modifier = Modifier.background(color))
    }
