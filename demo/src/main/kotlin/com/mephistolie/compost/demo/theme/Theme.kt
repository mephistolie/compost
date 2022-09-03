package com.mephistolie.compost.demo.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.shapes.DashedLineShape

object Colors {
    val white70 =  Color.White.copy(0.7F)
    val black5 =  Color.Black.copy(0.05F)
}

object Shapes {
    val roundedCornerShape8 = RoundedCornerShape(8.dp)
    val roundedCornerShape12 = RoundedCornerShape(12.dp)

    val cutCornerShape12 = CutCornerShape(12.dp)
    val circleCornerShape = RoundedCornerShape(percent = 100)

    val uniformDashedLine = DashedLineShape(10.dp)
    val nonuniformDashedLine = DashedLineShape(20.dp, 10.dp)
    val verticalDashedLine = DashedLineShape(6.dp, 4.dp, vertical = true)

}
