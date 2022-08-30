package com.mephistolie.compost.demo.screens.feature.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.shapes.DashedLineShape

fun LazyListScope.dashedLineShapeFeatureContent() {
    item {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.DarkGray, shape = DashedLineShape(10.dp))
        )
    }
    item {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.DarkGray, shape = DashedLineShape(20.dp, 10.dp))
        )
    }
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(10) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(2.dp)
                        .height(56.dp)
                        .background(color = Color.DarkGray, shape = DashedLineShape(6.dp, 4.dp, vertical = true))
                )
            }
        }
    }
}
