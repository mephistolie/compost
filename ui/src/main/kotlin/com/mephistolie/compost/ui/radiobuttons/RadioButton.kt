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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.modifiers.simpleClickable
import com.mephistolie.compost.ui.UiDefaults.iconSize
import com.mephistolie.compost.ui.UiDefaults.opaqueAlpha
import com.mephistolie.compost.ui.UiDefaults.radioButtonBorderFactor
import com.mephistolie.compost.ui.UiDefaults.radioButtonDotSizeFactor
import com.mephistolie.compost.ui.UiDefaults.transparentAlpha

/**
 * Analogue of standard [androidx.compose.material.RadioButton] with animated stroke instead of dot.
 *
 * @param isSelected whether is radio button selected
 * @param onClick will be called when the user clicks the radio button
 * @param modifier a [Modifier] for this text field
 * @param size size of radio button
 * @param dotSize size of radio button's inner circle
 * @param borderWidth thickness of radio button's stroke
 * @param color color of radio button
 * @param enabled whether is radio button clickable
 */
@Composable
fun RadioButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = iconSize,
    dotSize: Dp = size * radioButtonDotSizeFactor,
    borderWidth: Dp = size * radioButtonBorderFactor,
    color: Color = MaterialTheme.colors.secondary,
    enabled: Boolean = true,
) {
    val transition = updateTransition(isSelected, label = "isSelected")

    val alpha by transition.animateFloat(label = "alpha") { selected ->
        if (selected) opaqueAlpha else transparentAlpha
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
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .alpha(alpha)
                .clippedBackground(color, CircleShape)
                .size(dotSize)
        )
    }
}
