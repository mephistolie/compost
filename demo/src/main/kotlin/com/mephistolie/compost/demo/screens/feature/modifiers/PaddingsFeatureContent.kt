package com.mephistolie.compost.demo.screens.feature.modifiers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.theme.Shapes.roundedCornerShape12
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.modifiers.padding

fun LazyListScope.paddingsFeatureContent() {
    item {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "HORIZONTAL + TOP/BOTTOM",
                color = Color.White,
                modifier = Modifier
                    .clippedBackground(MaterialTheme.colors.primary, roundedCornerShape12)
                    .padding(horizontal = 32.dp, top = 12.dp, bottom = 64.dp)
            )
            Text(
                text = "VERTICAL + START/END",
                color = Color.White,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .clippedBackground(MaterialTheme.colors.primary, roundedCornerShape12)
                    .padding(vertical = 32.dp, start = 12.dp, end = 64.dp)
            )
        }
    }
}
