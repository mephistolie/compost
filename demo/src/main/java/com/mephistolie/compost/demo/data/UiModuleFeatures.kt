package com.mephistolie.compost.demo.data

import com.mephistolie.compost.demo.models.Feature
import com.mephistolie.compost.demo.models.FeatureGroup
import com.mephistolie.compost.demo.models.FeatureType

val uiFeatures = listOf(
    FeatureGroup(
        name = "Text Fields",
        features = listOf(
            Feature(
                name = "TextField",
                description = "Analogue of standard TextField with more freedom. Instead of original it has modifiable paddings and doesn't apply background, minimum size and indicator line modifiers. You can add them by pass suitable modifier by default. Also singleLine argument reduced to maxLines.",
                type = FeatureType.TEXT_FIELD
            ),
            Feature(
                name = "IndicatorLineTextField",
                description = "TextField with customizable indicator line. It also hasn't horizontal paddings by default, so text will be printed exactly from the beginning of the line.",
                type = FeatureType.INDICATOR_LINE_TEXT_FIELD,
            ),
        ),
    ),
    FeatureGroup(
        name = "Buttons",
        features = listOf(
            Feature(
                name = "CircleIconButton",
                description = "Round button with icon.",
                type = FeatureType.CIRCLE_ICON_BUTTON
            ),
            Feature(
                name = "CircleImageButton",
                description = "Round button with image. Useful when need to use a multicolor image. In other cases use function above.",
                type = FeatureType.CIRCLE_IMAGE_BUTTON
            ),
            Feature(
                name = "TextButton",
                description = "Button with text inside.",
                type = FeatureType.TEXT_BUTTON
            ),
        ),
    ),
    FeatureGroup(
        name = "Checkboxes",
        features = listOf(
            Feature(
                name = "Checkbox",
                description = "Animated analogue of standard Checkbox with customizable shape.",
                type = FeatureType.CHECKBOX
            ),
            Feature(
                name = "CircleCheckbox",
                description = "Checkbox implementation with circle shape.",
                type = FeatureType.CIRCLE_CHECKBOX
            ),
            Feature(
                name = "RectangleCheckbox",
                description = "Checkbox implementation with rectangle shape. Supports corner radius.",
                type = FeatureType.RECTANGLE_CHECKBOX
            ),
        ),
    ),
)
