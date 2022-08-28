package com.mephistolie.compost.demo.data

import com.mephistolie.compost.demo.models.Feature
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.models.FeatureType

val coreFeatures = listOf(
    FeatureGroup(
        name = "Scope Extensions",
        features = listOf(
            Feature(
                name = "Shading",
                description ="Useful for Boxes that can be pressed. Instead of standard ripple this one is fade animated. " +
                        "Multiple shadings can be managed by single bool (for example, to create shading effect on whole complex item card).",
                type = FeatureType.SHADING
            ),
            Feature(
                name = "gridItems",
                description ="Creates grid of elements for LazyColumn. In most cases you should use " +
                        "standard LazyVerticalGrid / LazyHorizontalGrid with specified spans. However " +
                        "if you need to place a few grids with columns GCD equals 1 (2 and 3) at single screen, " +
                        "it would be a problem. This extension is a temporary fix.",
                type = FeatureType.GRID_ITEMS
            ),
        ),
    ),
    FeatureGroup(
        name = "Modifiers",
        features = listOf(
            Feature(
                name = "simpleClickable()",
                description ="Allows you to set on click action without ripple effect and extra args.",
                type = FeatureType.SIMPLE_CLICKABLE
            ),
            Feature(
                name = "scalingClickable()",
                description ="Allows you to change element size on click.",
                type = FeatureType.SCALING_CLICKABLE
            ),
            Feature(
                name = "debounceClickable()",
                description ="Allows you to set click timeout to prevent extra clicks.",
                type = FeatureType.DEBOUNCE_CLICKABLE
            ),
        ),
    )
)
