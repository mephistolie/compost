package com.mephistolie.compost.demo.screens.feature.views.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.R
import com.mephistolie.compost.demo.theme.Colors
import com.mephistolie.compost.ui.buttons.CircleImageButton

fun LazyListScope.circleImageButtonFeatureContent() {
    item {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            CircleImageButton(
                image = painterResource(R.mipmap.ic_compose),
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = Colors.black5),
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(48.dp)
            )
        }
    }
}
