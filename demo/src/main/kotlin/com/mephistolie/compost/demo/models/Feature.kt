package com.mephistolie.compost.demo.models

import java.io.Serializable

data class Feature(
    val name: String,
    val description: String,
    val type: FeatureType,
) : Serializable

enum class FeatureType {

    //Runtime
    REMEMBER_SAVEABLE_MUTABLE_LIST,

    // Scope Extensions
    SHADING, GRID_ITEMS,

    // Modifiers
    PADDINGS,
    CLIPPED_BACKGROUND,
    SIMPLE_CLICKABLE, SCALING_CLICKABLE, DEBOUNCE_CLICKABLE,

    // Shapes
    DASHED_LINE_SHAPE,

    // Views
    TEXT_FIELD, INDICATOR_LINE_TEXT_FIELD,
    CIRCLE_ICON_BUTTON, CIRCLE_IMAGE_BUTTON, TEXT_BUTTON, PROGRESS_BUTTON,
    CHECKBOX, CIRCLE_CHECKBOX, RECTANGLE_CHECKBOX,
    RADIO_BUTTON, OUTLINE_RADIO_BUTTON,
}

data class FeatureGroup(
    val name: String,
    val features: List<Feature>,
) : Serializable
