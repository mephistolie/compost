package com.mephistolie.compost.demo.screens.feature.views.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.theme.Shapes
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.ui.buttons.ProgressButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun LazyListScope.progressButtonFeatureContent() {
    item {
        val isLoading = remember { mutableStateOf(false) }
        val coroutine = rememberCoroutineScope()
        ProgressButton(
            onClick = {
                isLoading.value = true
                coroutine.launch {
                    delay(5000)
                    isLoading.value = false
                }
            },
            isLoading = isLoading.value,
            indicatorColor = Color.White,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
                .height(48.dp)
                .clippedBackground(MaterialTheme.colors.primary, Shapes.circleCornerShape)
        ) {
            Text("PROGRESS BUTTON")
        }
    }
}
