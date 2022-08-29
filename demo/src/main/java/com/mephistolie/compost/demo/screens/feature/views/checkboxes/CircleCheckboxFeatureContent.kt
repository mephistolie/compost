package com.mephistolie.compost.demo.screens.feature.views.checkboxes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.ui.checkboxes.CircleCheckbox

fun LazyListScope.circleCheckboxFeatureComponent() {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(3) { index ->
                val isChecked = remember { mutableStateOf(false) }
                CircleCheckbox(
                    isChecked = isChecked.value,
                    checkmarkIcon = when(index) {
                        0 -> Icons.Default.Check
                        1 -> Icons.Outlined.Check
                        else -> Icons.Rounded.Check
                    },
                    size = 32.dp,
                    checkmarkSize = when(index) {
                        0 -> 24.dp
                        1 -> 18.dp
                        else -> 32.dp
                    },
                    checkedColor = MaterialTheme.colors.primary,
                    onClick = { isChecked.value = !isChecked.value },
                    modifier = Modifier
                        .padding(end = 12.dp)
                )
            }
        }
    }
}
