package com.mephistolie.compost.ui.textfields

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.FocusedBorderThickness
import androidx.compose.material.TextFieldDefaults.UnfocusedBorderThickness
import androidx.compose.material.TextFieldDefaults.indicatorLine
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import com.mephistolie.compost.ui.UiDefaults.labeledTextFieldVerticalPaddings
import com.mephistolie.compost.ui.UiDefaults.textFieldVerticalPaddings

/**
 * [TextField] with customizable indicator line. It also hasn't horizontal paddings by default,
 * so text will be printed exactly from the beginning of the line.
 *
 * @param value the input text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param modifier a [Modifier] for this text field
 * @param enabled controls the enabled state of the [TextField]. When `false`, the text field will
 * be neither editable nor focusable, the input of the text field will not be selectable,
 * visually text field will appear in the disabled UI state
 * @param readOnly controls the editable state of the [TextField]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param textStyle the style to be applied to the input text. The default [textStyle] uses the
 * [LocalTextStyle] defined by the theme
 * @param cursorBrush the brush to be applied to cursor
 * @param label the optional label to be displayed inside the text field container. The default
 * text style for internal [Text] is [Typography.caption] when the text field is in focus and
 * [Typography.subtitle1] when the text field is not in focus
 * @param placeholder the optional placeholder to be displayed when the text field is in focus and
 * the input text is empty. The default text style for internal [Text] is [Typography.subtitle1]
 * @param leadingIcon the optional leading icon to be displayed at the beginning of the text field
 * container
 * @param trailingIcon the optional trailing icon to be displayed at the end of the text field
 * container
 * @param isError indicates if the text field's current value is in error. If set to true, the
 * label, bottom indicator and trailing icon by default will be displayed in error color
 * @param visualTransformation transforms the visual representation of the input [value]
 * For example, you can use
 * [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation] to
 * create a password text field. By default no visual transformation is applied
 * @param keyboardOptions software keyboard options that contains configuration such as
 * [KeyboardType] and [ImeAction].
 * @param keyboardActions when the input service emits an IME action, the corresponding callback
 * is called. Note that this IME action may be different from what you specified in
 * [KeyboardOptions.imeAction].
 * @param maxLines the maximum height in terms of maximum number of visible lines. Should be
 * equal or greater than 1.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this TextField. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this TextField in different [Interaction]s.
 * @param colors [TextFieldColors] that will be used to resolve color of the text, content
 * (including label, placeholder, leading and trailing icons, indicator line) and background for
 * this text field in different states. See [TextFieldDefaults.textFieldColors]
 * @param contentPadding [PaddingValues] that will be applied to actual text area resolve colors of the text field
 * @param indicatorLineEnabled whether the indicator line is enabled
 * @param focusedIndicatorLineThickness thickness of the indicator line when text field is focused
 * @param unfocusedIndicatorLineThickness thickness of the indicator line when text field is
 * not focused
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IndicatorLineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    cursorBrush: Brush = SolidColor(Color.Black),
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(),
    contentPadding: PaddingValues =
        if (label == null) textFieldVerticalPaddings else labeledTextFieldVerticalPaddings,
    indicatorLineEnabled: Boolean = enabled,
    focusedIndicatorLineThickness: Dp = FocusedBorderThickness,
    unfocusedIndicatorLineThickness: Dp = UnfocusedBorderThickness,
) =
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .indicatorLine(
                enabled = indicatorLineEnabled,
                isError = isError,
                interactionSource = interactionSource,
                colors = colors,
                focusedIndicatorLineThickness = focusedIndicatorLineThickness,
                unfocusedIndicatorLineThickness = unfocusedIndicatorLineThickness,
            ),
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        cursorBrush = cursorBrush,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        maxLines = maxLines,
        interactionSource = interactionSource,
        colors = colors,
        contentPadding = contentPadding,
    )
