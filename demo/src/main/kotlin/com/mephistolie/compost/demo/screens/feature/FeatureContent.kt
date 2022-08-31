package com.mephistolie.compost.demo.screens.feature

import androidx.compose.foundation.lazy.LazyListScope
import com.mephistolie.compost.demo.models.Feature
import com.mephistolie.compost.demo.models.FeatureType
import com.mephistolie.compost.demo.screens.feature.extensions.gridItemsFeatureContent
import com.mephistolie.compost.demo.screens.feature.extensions.shadingFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.clippedBackgroundFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.debounceClickableFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.scalingClickableFeatureContent
import com.mephistolie.compost.demo.screens.feature.modifiers.simpleClickableFeatureContent
import com.mephistolie.compost.demo.screens.feature.shapes.dashedLineShapeFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.textfields.indicatorLineTextFieldFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.textfields.textFieldFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.circleIconButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.circleImageButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.progressButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.buttons.textButtonFeatureContent
import com.mephistolie.compost.demo.screens.feature.views.checkboxes.checkboxFeatureComponent
import com.mephistolie.compost.demo.screens.feature.views.checkboxes.circleCheckboxFeatureComponent
import com.mephistolie.compost.demo.screens.feature.views.checkboxes.rectangleCheckboxFeatureComponent
import com.mephistolie.compost.demo.screens.feature.views.radiobuttons.outlineRadioButtonFeatureComponent
import com.mephistolie.compost.demo.screens.feature.views.radiobuttons.radioButtonFeatureComponent

fun LazyListScope.featureContent(
    feature: Feature,
) {
    when (feature.type) {
        FeatureType.SHADING -> shadingFeatureContent()
        FeatureType.GRID_ITEMS -> gridItemsFeatureContent()

        FeatureType.CLIPPED_BACKGROUND -> clippedBackgroundFeatureContent()
        FeatureType.SIMPLE_CLICKABLE -> simpleClickableFeatureContent()
        FeatureType.SCALING_CLICKABLE -> scalingClickableFeatureContent()
        FeatureType.DEBOUNCE_CLICKABLE -> debounceClickableFeatureContent()

        FeatureType.DASHED_LINE_SHAPE -> dashedLineShapeFeatureContent()

        FeatureType.TEXT_FIELD -> textFieldFeatureContent()
        FeatureType.INDICATOR_LINE_TEXT_FIELD -> indicatorLineTextFieldFeatureContent()

        FeatureType.CIRCLE_ICON_BUTTON -> circleIconButtonFeatureContent()
        FeatureType.CIRCLE_IMAGE_BUTTON -> circleImageButtonFeatureContent()
        FeatureType.TEXT_BUTTON -> textButtonFeatureContent()
        FeatureType.PROGRESS_BUTTON -> progressButtonFeatureContent()

        FeatureType.CHECKBOX -> checkboxFeatureComponent()
        FeatureType.CIRCLE_CHECKBOX -> circleCheckboxFeatureComponent()
        FeatureType.RECTANGLE_CHECKBOX -> rectangleCheckboxFeatureComponent()

        FeatureType.RADIO_BUTTON -> radioButtonFeatureComponent()
        FeatureType.OUTLINE_RADIO_BUTTON -> outlineRadioButtonFeatureComponent()
    }
}
