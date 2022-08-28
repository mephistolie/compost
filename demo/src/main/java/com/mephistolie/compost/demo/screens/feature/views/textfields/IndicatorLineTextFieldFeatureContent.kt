package com.mephistolie.compost.demo.screens.feature.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.ui.textfields.IndicatorLineTextField

@OptIn(ExperimentalComposeUiApi::class)
fun LazyListScope.IndicatorLineTextFieldFeatureContent() {
    item {
        val keyboardController = LocalSoftwareKeyboardController.current

        Column {
            val firstText = remember { mutableStateOf("") }
            val secondText = remember { mutableStateOf("") }
            IndicatorLineTextField(
                value = firstText.value,
                onValueChange = { value -> firstText.value = value },
                label = {
                    Text("Indicator Line Text Field")
                },
                keyboardActions = KeyboardActions { keyboardController?.hide() },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White.copy(alpha = 0.7F))
            )
            IndicatorLineTextField(
                value = secondText.value,
                onValueChange = { value -> secondText.value = value },
                label = {
                    Text("Indicator Line Text Field with Icon")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                keyboardActions = KeyboardActions { keyboardController?.hide() },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White.copy(alpha = 0.7F))
            )
        }
    }
}
