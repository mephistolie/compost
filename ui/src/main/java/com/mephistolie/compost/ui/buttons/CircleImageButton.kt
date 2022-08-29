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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Round button with icon.
 *
 * @param image [Painter] to draw
 * @param onClick Will be called when the user clicks the button
 * @param modifier a [Modifier] to be applied to the button
 * @param imageModifier a [Modifier] to be applied to the image
 * @param contentPadding The spacing values to apply internally between the container and the icon
 * @param background the background color of button
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes,
 * and does not represent a meaningful action that a user can take. This text should be
 * localized, such as by using [androidx.compose.ui.res.stringResource] or similar
 */
@Composable
fun CircleImageButton(
    image: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    contentPadding: Dp = 0.dp,
    background: Color = Color.Black.copy(alpha = 0.05F),
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
            painter = image,
            contentDescription = contentDescription,
            modifier = imageModifier,
        )
    }
}
