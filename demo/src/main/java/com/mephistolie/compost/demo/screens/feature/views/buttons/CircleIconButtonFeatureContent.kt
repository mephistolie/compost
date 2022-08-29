package com.mephistolie.compost.demo.screens.feature.views.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.ui.buttons.CircleIconButton

fun LazyListScope.circleIconButtonFeatureContent() {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(3) { index ->
                CircleIconButton(
                    icon = when(index) {
                        0 -> Icons.Default.Add
                        1 -> Icons.Default.Home
                        else -> Icons.Default.Refresh
                    },
                    onClick = {},
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .size(48.dp)
                )
            }
        }
    }
}
