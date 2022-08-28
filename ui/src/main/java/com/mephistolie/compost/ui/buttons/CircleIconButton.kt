package com.mephistolie.compost.ui.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Round button with image. Useful when need to use a pixel image. In other cases use [CircleImageButton]
 *
 * @param icon [ImageVector] to draw
 * @param onClick Will be called when the user clicks the button
 * @param modifier a [Modifier] to be applied to the button
 * @param iconModifier a [Modifier] to be applied to the icon
 * @param contentPadding The spacing values to apply internally between the container and the icon
 * @param tint tint to be applied to [imageVector]. If [Color.Unspecified] is provided, then no
 * tint is applied
 * @param background the background color of button
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes,
 * and does not represent a meaningful action that a user can take. This text should be
 * localized, such as by using [androidx.compose.ui.res.stringResource] or similar
 */
@Composable
fun CircleIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    contentPadding: Dp = 0.dp,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
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
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = iconModifier,
            tint = tint,
        )
    }
}
