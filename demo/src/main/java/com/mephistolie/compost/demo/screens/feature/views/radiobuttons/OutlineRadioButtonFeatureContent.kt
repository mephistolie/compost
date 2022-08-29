package com.mephistolie.compost.demo.screens.feature.views.radiobuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.ui.radiobuttons.OutlineRadioButton

fun LazyListScope.outlineRadioButtonFeatureComponent() {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            val selectedRadioButton = remember { mutableStateOf(0) }
            repeat(3) { index ->
                OutlineRadioButton(
                    isSelected = selectedRadioButton.value == index,
                    size = 32.dp,
                    color = MaterialTheme.colors.primary,
                    onClick = { selectedRadioButton.value = index },
                    modifier = Modifier
                        .padding(end = 12.dp)
                )
            }
        }
    }
}
