package com.mephistolie.compost.extensions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Creates grid of elements for LazyColumn.
 * In most cases you should use standard `LazyVerticalGrid` / `LazyHorizontalGrid` with specified spans.
 * However if you need to place a few grids with columns GCD equals 1 (2 and 3) at single screen,
 * it would be a problem. This extension is a temporary fix.<p>Originally written at
 * [StackOverflow](https://stackoverflow.com/questions/69336555/fixed-grid-inside-lazycolumn-in-jetpack-compose)
 * by [Phil Dukhov](https://stackoverflow.com/users/3585796/phil-dukhov)
 *
 * @param count count of items
 * @param columns count of columns for grid
 * @param horizontalArrangement [Arrangement] that will be applied to inner [Row]
 * @param itemContent item cell
 */
fun LazyListScope.gridItems(
    count: Int,
    columns: Int,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(Int) -> Unit,
) {
    gridItems(
        data = List(count) { it },
        columns = columns,
        horizontalArrangement = horizontalArrangement,
        itemContent = itemContent,
    )
}

/**
 * Creates grid of elements for LazyColumn.
 * In most cases you should use standard `LazyVerticalGrid` / `LazyHorizontalGrid` with specified spans.
 * However if you need to place a few grids with columns GCD equals 1 (2 and 3) at single screen,
 * it would be a problem. This extension is a temporary fix.<p>Originally written at
 * [StackOverflow](https://stackoverflow.com/questions/69336555/fixed-grid-inside-lazycolumn-in-jetpack-compose)
 * by [Phil Dukhov](https://stackoverflow.com/users/3585796/phil-dukhov)
 *
 * @param data list of items
 * @param columns count of columns for grid
 * @param horizontalArrangement [Arrangement] that will be applied to inner [Row]
 * @param itemContent item cell
 */
fun <T> LazyListScope.gridItems(
    data: List<T>,
    columns: Int,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    itemContent: @Composable BoxScope.(T) -> Unit,
) {
    val rows = if (data.isEmpty()) 0 else 1 + (data.count() - 1) / columns
    items(rows) { rowIndex ->
        Row(horizontalArrangement = horizontalArrangement) {
            for (columnIndex in 0 until columns) {
                val itemIndex = rowIndex * columns + columnIndex
                if (itemIndex < data.count()) {
                    Box(
                        modifier = Modifier.weight(1f, fill = true),
                        propagateMinConstraints = true
                    ) {
                        itemContent(data[itemIndex])
                    }
                } else {
                    Spacer(Modifier.weight(1f, fill = true))
                }
            }
        }
    }
}
