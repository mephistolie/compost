package com.mephistolie.compost.modifiers

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

fun Modifier.clippedBackground(
    background: Color,
    shape: Shape,
): Modifier = this
    .clip(shape)
    .background(background, shape)
