package com.mephistolie.compost.demo.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.mephistolie.compost.demo.data.coreFeatures
import com.mephistolie.compost.demo.data.uiFeatures
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.models.Module
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    pagerState: PagerState,
    onGroupClick: (FeatureGroup) -> Unit,
) {
    val coroutine = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
        ) {
            Module.values().forEachIndexed { index, tab ->
                Tab(
                    selected = index == pagerState.currentPage,
                    onClick = { coroutine.launch { pagerState.scrollToPage(index) } },
                ) {
                    Text(
                        text = tab.name,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
            }
        }
        HorizontalPager(
            count = Module.values().size,
            state = pagerState,
            modifier = Modifier
                .animateContentSize()
                .fillMaxHeight(),
            verticalAlignment = Alignment.Top,
        ) { pageIndex ->
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxWidth()
            ) {
                when (pageIndex) {
                    Module.CORE.ordinal -> GroupList(
                        groups = coreFeatures,
                        onGroupClick = onGroupClick,
                    )
                    Module.UI.ordinal -> GroupList(
                        groups = uiFeatures,
                        onGroupClick = onGroupClick,
                    )
                }
            }
        }
    }
}
