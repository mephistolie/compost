package com.mephistolie.compost.ui.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

/**
 * Button with text inside.
 *
 * @param text text to be add to button
 * @param onClick will be called when the user clicks the button
 * @param modifier modifier to be applied to the button
 * @param textModifier modifier to be applied to the text
 * @param enabled controls the enabled state of the button. When `false`, this button will not
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
 * @param textColor [Color] to apply to the text. If [Color.Unspecified], and [style] has no color set,
 * this will be [LocalContentColor].
 * @param background [Color] to apply to the button.
 * @param contentPadding The spacing values to apply internally between the container and the content
 * @param fontSize The size of glyphs to use when painting the text. See [TextStyle.fontSize].
 * @param fontStyle The typeface variant to use when drawing the letters (e.g., italic).
 * See [TextStyle.fontStyle].
 * @param fontWeight The typeface thickness to use when painting the text (e.g., [FontWeight.Bold]).
 * @param fontFamily The font family to be used when rendering the text. See [TextStyle.fontFamily].
 * @param letterSpacing The amount of space to add between each letter.
 * See [TextStyle.letterSpacing].
 * @param textDecoration The decorations to paint on the text (e.g., an underline).
 * See [TextStyle.textDecoration].
 * @param textAlign The alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param textStyle Style configuration for the text such as color, font, line height etc.
 */
@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    textColor: Color = Color.Unspecified,
    background: Color = Color.Black.copy(alpha = 0.05F),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle = LocalTextStyle.current
) {
    val colors = ButtonDefaults.buttonColors(backgroundColor = background, contentColor = textColor)

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
    ) {
        Text(
            text = text,
            modifier = textModifier,
            color = colors.contentColor(enabled = enabled).value,
            fontSize = fontSize,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            textAlign = textAlign,
            maxLines = 1,
            style = textStyle
        )
    }
}
