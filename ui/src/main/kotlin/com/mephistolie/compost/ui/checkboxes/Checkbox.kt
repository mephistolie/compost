package com.mephistolie.compost.ui.checkboxes

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.mephistolie.compost.modifiers.simpleClickable
import com.mephistolie.compost.ui.UiDefaults.CHECKBOX_CORNER_RADIUS_FACTOR
import com.mephistolie.compost.ui.UiDefaults.iconSize
import com.mephistolie.compost.ui.UiDefaults.ALPHA_OPAQUE
import com.mephistolie.compost.ui.UiDefaults.SELECTED_CHECKBOX_BORDER_FACTOR
import com.mephistolie.compost.ui.UiDefaults.ALPHA_TRANSPARENT
import com.mephistolie.compost.ui.UiDefaults.UNSELECTED_CHECKBOX_BORDER_FACTOR

/**
 * Animated analogue of standard [androidx.compose.material.Checkbox] with customizable shape.
 *
 * @param isChecked whether is checkbox checked
 * @param onClick will be called when the user clicks the checkbox
 * @param modifier a [Modifier] for this text field
 * @param checkmarkIcon icon for checked element
 * @param size size of checkbox
 * @param shape shape of checkbox
 * @param checkmarkSize size of [checkmarkIcon]
 * @param checkedColor color of box for checked element
 * @param uncheckedColor color of box for unchecked element
 * @param checkmarkColor color of [checkmarkIcon]
 * @param enabled whether is checkbox clickable
 */
@Composable
fun Checkbox(
    isChecked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    checkmarkIcon: ImageVector = Icons.Rounded.Check,
    size: Dp = iconSize,
    shape: Shape = RoundedCornerShape(size * CHECKBOX_CORNER_RADIUS_FACTOR),
    checkmarkSize: Dp = size,
    checkedColor: Color = MaterialTheme.colors.secondary,
    uncheckedColor: Color = checkedColor,
    checkmarkColor: Color = MaterialTheme.colors.surface,
    enabled: Boolean = true,
) {
    val transition = updateTransition(isChecked, label = "isChecked")

    val borderWidth by transition.animateDp(label = "borderWidth") { checked ->
        if (checked) size * SELECTED_CHECKBOX_BORDER_FACTOR else size * UNSELECTED_CHECKBOX_BORDER_FACTOR
    }

    val alpha by transition.animateFloat(label = "alpha") { checked ->
        if (checked) ALPHA_OPAQUE else ALPHA_TRANSPARENT
    }

    val backgroundColor by transition.animateColor(label = "backgroundColor") { checked ->
        if (checked) checkedColor else uncheckedColor
    }

    var baseModifier = modifier
        .size(size)
        .clip(shape)
    if (enabled) baseModifier = baseModifier.simpleClickable(onClick = onClick)


    val checkboxModifier =
        Modifier
            .fillMaxSize()
            .border(
                BorderStroke(
                    width = borderWidth,
                    color = backgroundColor,
                ),
                shape = shape,
            )

    Box(
        modifier = baseModifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = checkboxModifier
        )
        Icon(
            imageVector = checkmarkIcon,
            tint = checkmarkColor,
            contentDescription = null,
            modifier = Modifier
                .size(checkmarkSize)
                .alpha(alpha)
        )
    }
}
