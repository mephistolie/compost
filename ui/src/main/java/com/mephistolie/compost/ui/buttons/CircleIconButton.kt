package com.mephistolie.compost.ui.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: Dp = 0.dp,
    background: Color = Color.LightGray,
    contentDescription: String? = null
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = background),
        elevation = null,
        contentPadding = PaddingValues(contentPadding),
        modifier = modifier.aspectRatio(1F)
    ) {
        Image(
            imageVector = icon,
            contentDescription = contentDescription,
        )
    }
}
