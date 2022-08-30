package com.mephistolie.compost.ui.buttons

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Button with loading animation support and customizable progress indicator.
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param indicatorModifier Modifier to be applied to the progress indicator
 * @param indicatorSize Size of indicator
 * @param isLoading Loading State
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Button. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Button in different [Interaction]s.
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Pass `null` here to disable
 * elevation for this button. See [ButtonDefaults.elevation].
 * @param shape Defines the button's shape as well as its shadow
 * @param border Border to draw around the button
 * @param colors [ButtonColors] that will be used to resolve the background and content color for
 * this button in different states. See [ButtonDefaults.buttonColors].
 * @param contentPadding The spacing values to apply internally between the container and the content
 * @param indicatorColor Color of progress indicator
 * @param indicatorStrokeWidth Width of progress indicator stroke
 */
@Composable
fun ProgressButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    indicatorModifier: Modifier = Modifier.size(28.dp),
    isLoading: Boolean = false,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    indicatorColor: Color = MaterialTheme.colors.primary,
    indicatorStrokeWidth: Dp = 3.dp,
    indicator: @Composable BoxScope.() -> Unit = {
        CircularProgressIndicator(
            modifier = indicatorModifier,
            color = indicatorColor,
            strokeWidth = indicatorStrokeWidth,
        )
    },
    content: @Composable BoxScope.() -> Unit
) {
    val progressColors = ButtonDefaults.buttonColors(
        backgroundColor = colors.backgroundColor(enabled = true).value,
        contentColor = colors.contentColor(enabled = true).value,
        disabledBackgroundColor = colors.backgroundColor(enabled = isLoading).value,
        disabledContentColor = colors.contentColor(enabled = isLoading).value,
    )

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !isLoading,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = progressColors,
        contentPadding = if (!isLoading) contentPadding else PaddingValues(0.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            androidx.compose.animation.AnimatedVisibility(visible = !isLoading, enter = fadeIn(), exit = fadeOut()) {
                content()
            }
            androidx.compose.animation.AnimatedVisibility(visible = isLoading, enter = fadeIn(), exit = fadeOut()) {
                indicator()
            }
        }
    }
}
