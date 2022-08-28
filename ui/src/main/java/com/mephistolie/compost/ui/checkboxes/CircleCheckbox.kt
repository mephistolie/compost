package com.mephistolie.compost.ui.checkboxes

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleCheckbox(
    isChecked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    checkmarkIcon: ImageVector = Icons.Rounded.Check,
    size: Dp = 24.dp,
    checkmarkSize: Dp = size,
    checkedColor: Color = MaterialTheme.colors.secondary,
    uncheckedColor: Color = checkedColor,
    checkmarkColor: Color = MaterialTheme.colors.surface,
    enabled: Boolean = true,
) = Checkbox(
    isChecked = isChecked,
    onClick = onClick,
    shape = CircleShape,
    modifier = modifier,
    checkmarkIcon = checkmarkIcon,
    size = size,
    checkmarkSize = checkmarkSize,
    checkedColor = checkedColor,
    uncheckedColor = uncheckedColor,
    checkmarkColor = checkmarkColor,
    enabled = enabled
)
