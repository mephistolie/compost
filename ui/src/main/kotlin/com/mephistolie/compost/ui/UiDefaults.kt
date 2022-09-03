package com.mephistolie.compost.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

/**
 * Contains the default values used by Compost UI.
 */
internal object UiDefaults {

    // Common
    const val ALPHA_TRANSPARENT = 0F
    const val ALPHA_OPAQUE = 1F
    val zeroPadding = 0.dp
    const val SQUARE_RATIO = 1F
    val iconSize = 24.dp

    // Buttons
    val progressButtonIndicatorSize = 28.dp
    val progressButtonIndicatorStrokeWidth = 3.dp

    // Text Fields
    const val SINGLE_LINE = 1
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
    const val SELECTED_CHECKBOX_BORDER_FACTOR = 1F / 2
    const val UNSELECTED_CHECKBOX_BORDER_FACTOR = 1F / 12
    const val CHECKBOX_CORNER_RADIUS_FACTOR = 1F / 4

    // Radio Buttons
    const val RADIO_BUTTON_DOT_SIZE_FACTOR = 3F / 4
    const val RADIO_BUTTON_BORDER_FACTOR = 1F / 12
    const val OUTLINE_RADIO_BUTTON_SELECTED_BORDER_FACTOR = 1F / 3
    const val OUTLINE_RADIO_BUTTON_UNSELECTED_BORDER_FACTOR = 1F / 12

}
