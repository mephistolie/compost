package com.mephistolie.compost.ui.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.mephistolie.compost.ui.UiDefaults.SQUARE_RATIO
import com.mephistolie.compost.ui.UiDefaults.zeroPadding

/**
 * Round button with icon.
 *
 * @param image [Painter] to draw
 * @param onClick Will be called when the user clicks the button
 * @param modifier a [Modifier] to be applied to the button
 * @param imageModifier a [Modifier] to be applied to the image
 * @param contentPadding The spacing values to apply internally between the container and the icon
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
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
    contentPadding: Dp = zeroPadding,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentDescription: String? = null
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = colors,
        elevation = null,
        contentPadding = PaddingValues(contentPadding),
        modifier = modifier
            .aspectRatio(SQUARE_RATIO),
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            modifier = imageModifier,
        )
    }
}
