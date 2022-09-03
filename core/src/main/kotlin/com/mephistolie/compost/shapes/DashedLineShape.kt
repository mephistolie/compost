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
 * A shape describing the dashed line.
 *
 * @property dashWidth a length of dash
 * @property dashGap a length of space between dashes
 * @property vertical controls line direction: horizontal or vertical
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
        val primarySizeLength = if (!vertical) size.width else size.height
        val secondarySizeLength = if (!vertical) size.height else size.width

        val (dashWidthPx, dashGapPx) = with(density) { Pair(dashWidth.toPx(), dashGap.toPx()) }
        val stepWidth = dashWidthPx + dashGapPx
        val stepsCount = (primarySizeLength / stepWidth).roundToInt()
        val realStepWidth = primarySizeLength / stepsCount
        val dashWidthToStepWidthRatio = dashWidthPx / stepWidth
        val realDashWidth = realStepWidth * dashWidthToStepWidthRatio
        val dashSize = Size(
            width = if (!vertical) realDashWidth else secondarySizeLength,
            height = if (!vertical) secondarySizeLength else realDashWidth,
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
