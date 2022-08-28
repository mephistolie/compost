package com.mephistolie.compost.shapes

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.roundToInt

/**
 * A shape describing the dashed line
 *
 * @param dashWidth a length of dash
 * @param dashGap a length of space between dashes
 * @param vertical controls line direction: horizontal or vertical
 */
data class DashedLineShape(
    val dashWidth: Dp,
    val dashGap: Dp = dashWidth,
    val vertical: Boolean = false,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ) = Outline.Generic(Path().apply {
        val (dashWidthPx, dashGapPx) = with(density) { Pair(dashWidth.toPx(), dashGap.toPx()) }
        val stepWidth = dashWidthPx + dashGapPx
        val stepsCount = (size.width / stepWidth).roundToInt()
        val realStepWidth = size.width / stepsCount
        val dashWidthToStepWidthRatio = dashWidthPx / stepWidth
        val realDashWidth = realStepWidth * dashWidthToStepWidthRatio
        val dashSize = Size(
            width = if (!vertical) realDashWidth else size.height,
            height = if (!vertical) size.height else realDashWidth,
        )
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(
                        x = if (!vertical) i * realStepWidth else 0F,
                        y = if (!vertical) 0F else i * realStepWidth,
                    ),
                    size = dashSize
                )
            )
        }
        close()
    })
}
