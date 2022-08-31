package com.mephistolie.compost.ui.checkboxes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import com.mephistolie.compost.ui.UiDefaults.checkboxDefaultCornerRadiusFactor
import com.mephistolie.compost.ui.UiDefaults.iconSize

/**
 * [Checkbox] implementation with rounded rectangle shape.
 *
 * @param isChecked whether is checkbox checked
 * @param onClick will be called when the user clicks the checkbox
 * @param modifier a [Modifier] for this text field
 * @param checkmarkIcon icon for checked element
 * @param size size of checkbox
 * @param checkmarkSize size of [checkmarkIcon]
 * @param cornerRadius radius of checkbox corners
 * @param checkedColor color of box for checked element
 * @param uncheckedColor color of box for unchecked element
 * @param checkmarkColor color of [checkmarkIcon]
 * @param enabled whether is checkbox clickable
 */
@Composable
fun RectangleCheckbox(
    isChecked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    checkmarkIcon: ImageVector = Icons.Rounded.Check,
    size: Dp = iconSize,
    checkmarkSize: Dp = size,
    cornerRadius: Dp = size * checkboxDefaultCornerRadiusFactor,
    checkedColor: Color = MaterialTheme.colors.secondary,
    uncheckedColor: Color = checkedColor,
    checkmarkColor: Color = MaterialTheme.colors.surface,
    enabled: Boolean = true,
) = Checkbox(
    isChecked = isChecked,
    onClick = onClick,
    shape = RoundedCornerShape(cornerRadius),
    modifier = modifier,
    checkmarkIcon = checkmarkIcon,
    size = size,
    checkmarkSize = checkmarkSize,
    checkedColor = checkedColor,
    uncheckedColor = uncheckedColor,
    checkmarkColor = checkmarkColor,
    enabled = enabled
)
