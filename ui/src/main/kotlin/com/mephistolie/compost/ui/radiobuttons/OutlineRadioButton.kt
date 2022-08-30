package com.mephistolie.compost.ui.radiobuttons

import androidx.compose.animation.core.animateDp
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.modifiers.simpleClickable

/**
 * Animated analogue of standard [androidx.compose.material.RadioButton] with customizable shape.
 *
 * @param isSelected whether is radio button selected
 * @param onClick will be called when the user clicks the radio button
 * @param modifier a [Modifier] for this text field
 * @param size size of radio button
 * @param selectedBorderWidth thickness of selected radio button's stroke
 * @param unselectedBorderWidth thickness of unselected radio button's stroke
 * @param color color of radio button
 * @param enabled whether is radio button clickable
 */
@Composable
fun OutlineRadioButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    selectedBorderWidth: Dp = size / 3,
    unselectedBorderWidth: Dp = size / 12,
    color: Color = MaterialTheme.colors.secondary,
    enabled: Boolean = true,
) {
    val transition = updateTransition(isSelected, label = "isSelected")

    val borderWidth by transition.animateDp(label = "borderWidth") { selected ->
        if (selected) selectedBorderWidth else unselectedBorderWidth
    }

    var baseModifier = modifier.size(size)
    if (enabled) baseModifier = baseModifier.simpleClickable(onClick = onClick)

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
    )
}
