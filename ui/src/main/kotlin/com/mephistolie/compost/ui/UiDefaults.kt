package com.mephistolie.compost.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Contains the default values used by Compost UI.
 */
internal object UiDefaults {

    // Common
    const val transparentAlpha = 0F
    const val opaqueAlpha = 1F
    val zeroPadding = 0.dp
    const val squareRatio = 1F
    val iconSize = 24.dp

    // Buttons
    private const val buttonBackgroundAlpha = 0.05F
    val circleButtonBackground = Color.Black.copy(alpha = buttonBackgroundAlpha)

    // Text Fields
    const val singleLine = 1
    val textFieldVerticalPaddings = PaddingValues(
        start = 0.dp,
        top = 20.dp,
        end = 0.dp,
        bottom = 10.dp,
    )
    val labeledTextFieldVerticalPaddings = PaddingValues(
        start = 0.dp,
        top = 20.dp,
        end = 0.dp,
        bottom = 10.dp,
    )

    // Checkboxes
    const val selectedCheckboxBorderFactor = 1F / 2
    const val unselectedCheckboxBorderFactor = 1F / 12
    const val checkboxDefaultCornerRadiusFactor = 1F / 4

    // Radio Buttons
    const val radioButtonDotSizeFactor = 3F / 4
    const val radioButtonBorderFactor = 1F / 12
    const val outlineRadioButtonSelectedBorderFactor = 1F / 3
    const val outlineRadioButtonUnselectedBorderFactor = 1F / 12

}
