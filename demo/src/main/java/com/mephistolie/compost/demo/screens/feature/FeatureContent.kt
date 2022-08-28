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
import com.mephistolie.compost.demo.screens.feature.views.IndicatorLineTextFieldFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.TextFieldFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.CircleIconButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.CircleImageButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.TextButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.checkboxes.CheckboxCheckboxFeatureComponent
import com.mephistolie.compost.demo.screens.feature.views.checkboxes.CircleCheckboxCheckboxFeatureComponent
import com.mephistolie.compost.demo.screens.feature.views.checkboxes.RectangleCheckboxCheckboxFeatureComponent

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
        FeatureType.TEXT_FIELD -> TextFieldFeatureContent()
        FeatureType.INDICATOR_LINE_TEXT_FIELD -> IndicatorLineTextFieldFeatureContent()
        FeatureType.CIRCLE_ICON_BUTTON -> CircleIconButtonFeatureContent()
        FeatureType.CIRCLE_IMAGE_BUTTON -> CircleImageButtonFeatureContent()
        FeatureType.TEXT_BUTTON -> TextButtonFeatureContent()
        FeatureType.CHECKBOX -> CheckboxCheckboxFeatureComponent()
        FeatureType.CIRCLE_CHECKBOX -> CircleCheckboxCheckboxFeatureComponent()
        FeatureType.RECTANGLE_CHECKBOX -> RectangleCheckboxCheckboxFeatureComponent()
        else -> {}
    }
}
