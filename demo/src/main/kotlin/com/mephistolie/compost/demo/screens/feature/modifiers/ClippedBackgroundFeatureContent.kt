package com.mephistolie.compost.demo.screens.feature.modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.modifiers.clippedBackground

fun LazyListScope.clippedBackgroundFeatureContent() {
    item {
        Column {
            repeat(2) { index ->
                var modifier = Modifier
                    .padding(bottom = if (index == 0) 12.dp else 0.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                modifier = when (index) {
                    1 -> modifier
                        .clippedBackground(MaterialTheme.colors.primary, RoundedCornerShape(percent = 100))
                    else -> modifier
                        .background(MaterialTheme.colors.primary, RoundedCornerShape(percent = 100))
                }
                Box(
                    modifier = modifier
                        .clickable{},
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = when (index) {
                            1 -> "CLIPPED BACKGROUND"
                            else -> "STANDARD BACKGROUND"
                        },
                        color = Color.White
                    )
                }
            }
        }
    }
}
