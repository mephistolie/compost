package com.mephistolie.compost.demo.screens.feature.extensions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.theme.Shapes
import com.mephistolie.compost.extensions.Shading
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.modifiers.scalingClickable

fun LazyListScope.shadingFeatureContent() {
    item {
        val pressed = remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clippedBackground(
                    background = MaterialTheme.colors.primary,
                    shape = Shapes.roundedCornerShape8
                )
                .scalingClickable(
                    pressed = pressed,
                    scaleFactor = 1F,
                    onClick = {},
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "SHADING CLICKABLE BOX", color = Color.White)
            Shading(pressed.value)
        }
    }
}
