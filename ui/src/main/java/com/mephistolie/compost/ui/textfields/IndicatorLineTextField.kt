package com.mephistolie.compost.ui.textfields

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TextFieldDefaults.FocusedBorderThickness
import androidx.compose.material.TextFieldDefaults.UnfocusedBorderThickness
import androidx.compose.material.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
        if (label == null) {
            PaddingValues(vertical = 16.dp)
        } else {
            PaddingValues(
                start = 0.dp,
                top = 20.dp,
                end = 0.dp,
                bottom = 10.dp,
            )
        },
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
