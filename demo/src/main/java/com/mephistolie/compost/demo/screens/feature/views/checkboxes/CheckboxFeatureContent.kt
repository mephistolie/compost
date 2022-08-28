package com.mephistolie.compost.demo.screens.feature.views.checkboxes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.twotone.Check
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.ui.buttons.CircleIconButton
import com.mephistolie.compost.ui.checkboxes.Checkbox
import com.mephistolie.compost.ui.checkboxes.RectangleCheckbox

fun LazyListScope.CheckboxFeatureComponent() {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(3) { index ->
                val isChecked = remember { mutableStateOf(false) }
                Checkbox(
                    isChecked = isChecked.value,
                    checkmarkIcon = when(index) {
                        0 -> Icons.Default.Check
                        1 -> Icons.TwoTone.Check
                        else -> Icons.Rounded.Check
                    },
                    size = 32.dp,
                    shape = when(index) {
                        0 -> RoundedCornerShape(12.dp)
                        1 -> CutCornerShape(8.dp)
                        else -> CircleShape
                    },
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
