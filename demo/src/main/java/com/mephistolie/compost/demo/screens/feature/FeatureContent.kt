package com.mephistolie.compost.demo.screens.feature

import androidx.compose.foundation.lazy.LazyListScope
import com.mephistolie.compost.demo.models.Feature
import com.mephistolie.compost.demo.models.FeatureType
import com.mephistolie.compost.demo.screens.feature.extensions.GridItemsFeature
import com.mephistolie.compost.demo.screens.feature.extensions.ShadingFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.DebounceClickableFeature
import com.mephistolie.compost.demo.screens.feature.modifiers.ScalingClickableFeature
import com.mephistolie.compost.demo.screens.feature.modifiers.SimpleClickableFeature

fun LazyListScope.FeatureContent(
    feature: Feature,
) {
    when (feature.type) {
        FeatureType.SHADING -> ShadingFeatureContent()
        FeatureType.GRID_ITEMS -> GridItemsFeature()
        FeatureType.SIMPLE_CLICKABLE -> SimpleClickableFeature()
        FeatureType.SCALING_CLICKABLE -> ScalingClickableFeature()
        FeatureType.DEBOUNCE_CLICKABLE -> DebounceClickableFeature()
        else -> {}
    }
}
