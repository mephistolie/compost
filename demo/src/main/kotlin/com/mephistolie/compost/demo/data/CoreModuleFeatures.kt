package com.mephistolie.compost.demo.data

import com.mephistolie.compost.demo.models.Feature
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.models.FeatureType

val coreFeatures = listOf(
    FeatureGroup(
        name = "Runtime",
        features = listOf(
            Feature(
                name = "rememberMutableStateListOf()",
                description = "rememberSaveable() that ready to use with mutable lists. Make sure you understand " +
                        "why you are using it, cause it's a very specific scenario. In most cases data should be " +
                        "stored at view model.",
                type = FeatureType.REMEMBER_SAVEABLE_MUTABLE_LIST
            ),
        ),
    ),
    FeatureGroup(
        name = "Scope Extensions",
        features = listOf(
            Feature(
                name = "Shading",
                description = "Useful for Boxes that can be pressed. Instead of standard ripple this one is fade " +
                        "animated. Multiple shadings can be managed by single bool (for example, to create shading " +
                        "effect on whole complex item card).",
                type = FeatureType.SHADING
            ),
            Feature(
                name = "gridItems",
                description = "Creates grid of elements for LazyColumn. In most cases you should use " +
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
                name = "padding()",
                description = "Flexible wrapper of padding. Use horizontal/vertical and side paddings together to " +
                        "reduce arguments count.",
                type = FeatureType.PADDINGS
            ),
            Feature(
                name = "clippedBackground()",
                description = "Creates clipped background instead of standard background() that applies " +
                        "shape only visually. Suitable for clipping clickable modifier's ripple.",
                type = FeatureType.CLIPPED_BACKGROUND
            ),
            Feature(
                name = "simpleClickable()",
                description = "Allows you to set on click action without ripple effect and extra args.",
                type = FeatureType.SIMPLE_CLICKABLE
            ),
            Feature(
                name = "scalingClickable()",
                description = "Allows you to change element size on click.",
                type = FeatureType.SCALING_CLICKABLE
            ),
            Feature(
                name = "debounceClickable()",
                description = "Allows you to set click timeout to prevent extra clicks. Button below shows toasts " +
                        "and has 5 seconds debounce interval.",
                type = FeatureType.DEBOUNCE_CLICKABLE
            ),
        ),
    ),
    FeatureGroup(
        name = "Shapes",
        features = listOf(
            Feature(
                name = "DashedLineShape",
                description = "Provides horizontal/vertical dashed line shape for dividers. Supports unequal width " +
                        "and gap.",
                type = FeatureType.DASHED_LINE_SHAPE
            ),
        ),
    )
)
