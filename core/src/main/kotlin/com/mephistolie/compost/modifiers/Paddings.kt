package com.mephistolie.compost.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Flexible wrapper of [padding]. Use horizontal/vertical and side paddings together to reduce arguments count.
 *
 * @param horizontal Horizontal padding
 * @param vertical Vertical padding
 * @param start Start padding. If not stated, [horizontal] used
 * @param top Top padding. If not stated, [vertical] used
 * @param end End padding. If not stated, [horizontal] used
 * @param bottom Bottom padding. If not stated, [vertical] used
 *
 **/
fun Modifier.padding(
    horizontal: Dp = 0.dp,
    vertical: Dp = 0.dp,
    start: Dp? = null,
    top: Dp? = null,
    end: Dp? = null,
    bottom: Dp? = null,
) = padding(
    start = start ?: horizontal,
    top = top ?: vertical,
    end = end ?: horizontal,
    bottom = bottom ?: vertical,
)
