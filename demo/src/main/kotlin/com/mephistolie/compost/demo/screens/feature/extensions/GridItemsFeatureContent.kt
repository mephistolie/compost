package com.mephistolie.compost.demo.screens.feature.extensions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.theme.Shapes
import com.mephistolie.compost.extensions.gridItems
import com.mephistolie.compost.modifiers.clippedBackground

fun LazyListScope.gridItemsFeatureContent() {
    val dataset = List(10) { it + 1 }
    gridItems(
        data = dataset.subList(0, 4),
        columns = 2
    ) { item ->
        GridItemSample(item)
    }

    gridItems(
        data = dataset.subList(0, 6),
        columns = 3
    ) { item ->
        GridItemSample(item, background = MaterialTheme.colors.primaryVariant)
    }

    gridItems(
        data = dataset,
        columns = 5
    ) { item ->
        GridItemSample(item)
    }
}

@Composable
fun GridItemSample(
    item: Int,
    background: Color = MaterialTheme.colors.primary
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(4.dp)
            .clippedBackground(background, Shapes.roundedCornerShape12),
        contentAlignment = Alignment.Center
    ) {
        Text(text = item.toString(), color = Color.White)
    }
}
