package com.mephistolie.compost.demo.screens.feature

import androidx.compose.foundation.lazy.LazyListScope
import com.mephistolie.compost.demo.models.Feature
import com.mephistolie.compost.demo.models.FeatureType
import com.mephistolie.compost.demo.screens.feature.extensions.GridItemsFeatureContent
import com.mephistolie.compost.demo.screens.feature.extensions.ShadingFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.DebounceClickableFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.ScalingClickableFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.SimpleClickableFeatureContent
import com.mephistolie.compost.demo.screens.feature.shapes.DashedLineShapeFeatureContent

fun LazyListScope.FeatureContent(
    feature: Feature,
) {
    when (feature.type) {
        FeatureType.SHADING -> ShadingFeatureContent()
        FeatureType.GRID_ITEMS -> GridItemsFeatureContent()
        FeatureType.SIMPLE_CLICKABLE -> SimpleClickableFeatureContent()
        FeatureType.SCALING_CLICKABLE -> ScalingClickableFeatureContent()
        FeatureType.DEBOUNCE_CLICKABLE -> DebounceClickableFeatureContent()
        FeatureType.DASHED_LINE_SHAPE -> DashedLineShapeFeatureContent()
        else -> {}
    }
}
