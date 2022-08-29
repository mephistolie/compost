package com.mephistolie.compost.demo.screens.group

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.screens.feature.featureContent

@Composable
fun GroupScreen(
    group: FeatureGroup,
    onClose: () -> Unit,
) {
    Column {
        Row() {

        }
        TopAppBar(
            title = {
                Text(
                    text = group.name,
                    style = MaterialTheme.typography.h6,
                )
            },
            navigationIcon = {
                IconButton(onClick = onClose) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            elevation = 0.dp,
        )
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            group.features.forEach { feature ->
                item {
                    Text(
                        text = feature.name,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }
                item {
                    Text(
                        text = feature.description,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                            .align(Alignment.Start)
                    )
                }
                featureContent(feature)
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}
