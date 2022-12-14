package com.mephistolie.compost.demo.screens.feature.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.theme.Colors
import com.mephistolie.compost.demo.theme.Shapes
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.runtime.rememberSaveableMutableStateListOf
import com.mephistolie.compost.ui.buttons.TextButton

fun LazyListScope.rememberSaveableMutableStateListOfFeatureContent() {
    item {
        val data = rememberSaveableMutableStateListOf(mutableListOf(1))
        Column {
            Text(
                text = data.joinToString(),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TextButton(
                    text = "REMOVE ELEMENT",
                    onClick = { data.removeAt(data.size - 1) },
                    enabled = data.size > 1,
                    modifier = Modifier
                        .weight(1F)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clippedBackground(
                            background = if (data.size > 1) MaterialTheme.colors.primary else Colors.black5,
                            shape = Shapes.roundedCornerShape8
                        )
                )
                TextButton(
                    text = "ADD ELEMENT",
                    onClick = { data.add(data.size + 1) },
                    enabled = data.size < 10,
                    modifier = Modifier
                        .weight(1F)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clippedBackground(
                            background = if (data.size < 10) MaterialTheme.colors.primary else Colors.black5,
                            shape = Shapes.roundedCornerShape8
                        )
                )
            }
        }
    }
}
