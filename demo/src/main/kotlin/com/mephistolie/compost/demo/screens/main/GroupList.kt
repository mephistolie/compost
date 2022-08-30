package com.mephistolie.compost.demo.screens.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mephistolie.compost.demo.models.FeatureGroup

@Composable
fun GroupList(
    groups: List<FeatureGroup>,
    onGroupClick: (FeatureGroup) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        groups.forEach { group ->
            featureGroup(group = group, onGroupClick = onGroupClick)
        }
    }
}
