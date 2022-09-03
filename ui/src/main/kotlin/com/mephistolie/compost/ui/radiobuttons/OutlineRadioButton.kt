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
import com.mephistolie.compost.modifiers.simpleClickable
import com.mephistolie.compost.ui.UiDefaults.iconSize
import com.mephistolie.compost.ui.UiDefaults.OUTLINE_RADIO_BUTTON_SELECTED_BORDER_FACTOR
import com.mephistolie.compost.ui.UiDefaults.OUTLINE_RADIO_BUTTON_UNSELECTED_BORDER_FACTOR

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
    size: Dp = iconSize,
    selectedBorderWidth: Dp = size * OUTLINE_RADIO_BUTTON_SELECTED_BORDER_FACTOR,
    unselectedBorderWidth: Dp = size * OUTLINE_RADIO_BUTTON_UNSELECTED_BORDER_FACTOR,
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
