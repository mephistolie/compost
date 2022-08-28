package com.mephistolie.compost.ui.radiobuttons

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.modifiers.simpleClickable

@Composable
fun RadioButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    dotSize: Dp = size * 2/3,
    borderWidth: Dp = size / 12,
    color: Color = MaterialTheme.colors.secondary,
    enabled: Boolean = true,
) {
    val transition = updateTransition(isSelected, label = "isSelected")

    val alpha by transition.animateFloat(label = "alpha") { checked ->
        if (checked) 1F else 0F
    }

    var baseModifier = modifier.size(size)
    if (enabled) baseModifier = baseModifier.simpleClickable(onClick)

    Box(
        modifier = baseModifier
            .clip(CircleShape)
            .border(
                BorderStroke(
                    width = borderWidth,
                    color = color,
                ),
                shape = CircleShape,
            )
    ) {
        Box(
            modifier = Modifier
                .size(dotSize)
                .alpha(alpha)
        )
    }
}
