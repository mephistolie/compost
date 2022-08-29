package com.mephistolie.compost.demo.screens.feature.views.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.ui.textfields.TextField

@OptIn(ExperimentalComposeUiApi::class)
fun LazyListScope.textFieldFeatureContent() {
    item {
        val keyboardController = LocalSoftwareKeyboardController.current
        val firstText = remember { mutableStateOf("") }
        val secondText = remember { mutableStateOf("") }
        val thirdText = remember { mutableStateOf("") }

        Column {
            TextField(
                value = firstText.value,
                onValueChange = { value -> firstText.value = value },
                placeholder = { Text("Text Field") },
                keyboardActions = KeyboardActions { keyboardController?.hide() },
                maxLines = 1,
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = Color.Black.copy(alpha = 0.03F),
                        shape = RoundedCornerShape(12.dp)
                    ),
            )
            Row {
                TextField(
                    value = secondText.value,
                    onValueChange = { value -> secondText.value = value },
                    placeholder = { Text("Small Field") },
                    keyboardActions = KeyboardActions { keyboardController?.hide() },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .width(128.dp)
                        .height(56.dp)
                        .background(
                            color = Color.Black.copy(alpha = 0.03F),
                            shape = RoundedCornerShape(12.dp)
                        ),
                )
                TextField(
                    value = thirdText.value,
                    onValueChange = { value -> thirdText.value = value },
                    placeholder = { Text("No padding") },
                    keyboardActions = KeyboardActions { keyboardController?.hide() },
                    maxLines = 1,
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(
                            color = Color.Black.copy(alpha = 0.03F),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentPadding = PaddingValues(0.dp)
                )
            }
        }
    }
}
