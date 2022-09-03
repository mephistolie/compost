package com.mephistolie.compost.demo.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object Colors {
    val white70 =  Color.White.copy(0.7F)
    val black5 =  Color.Black.copy(0.05F)
}

object Shapes {
    val roundedCornerShape4 = RoundedCornerShape(4.dp)
    val roundedCornerShape8 = RoundedCornerShape(8.dp)
    val roundedCornerShape12 = RoundedCornerShape(12.dp)
    val cutCornerShape12 = CutCornerShape(12.dp)
    val circleCornerShape = RoundedCornerShape(percent = 100)
}