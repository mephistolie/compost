package com.mephistolie.compost.demo.screens.feature.views.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.theme.Shapes
import com.mephistolie.compost.modifiers.clippedBackground
import com.mephistolie.compost.ui.buttons.TextButton

fun LazyListScope.textButtonFeatureContent() {
    item {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            TextButton(
                text = "TEXT BUTTON",
                colors = ButtonDefaults.buttonColors(contentColor = Color.White),
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .clippedBackground(MaterialTheme.colors.primary, Shapes.circleCornerShape)
            )
            TextButton(
                text = "TEXT BUTTON",
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = MaterialTheme.colors.primaryVariant
                ),
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clippedBackground(MaterialTheme.colors.primaryVariant, Shapes.roundedCornerShape8)
            )
        }
    }
}
