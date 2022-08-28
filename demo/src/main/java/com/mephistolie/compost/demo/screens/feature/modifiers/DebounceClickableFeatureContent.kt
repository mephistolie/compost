package com.mephistolie.compost.demo.screens.feature.modifiers

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.extensions.Shading
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.modifiers.debounceClickable
import com.mephistolie.compost.modifiers.scalingClickable

fun LazyListScope.DebounceClickableFeatureContent() {
    item {
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clippedBackground(
                    background = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .debounceClickable(debounceInterval = 5000) {
                    Toast.makeText(context, "CLICKED", Toast.LENGTH_SHORT).show()
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "DEBOUNCE CLICKABLE BOX", color = Color.White)
        }
    }
}
