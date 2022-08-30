package com.mephistolie.compost.extensions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Used as an press effect. Instead of standard ripple this one is fade animated.
 * Multiple shadings can be managed by single bool (for example, to create shading effect on whole complex item card).
 *
 * @param isVisible whether is shading applied
 * @param color color used for shading
 */
@Composable
fun BoxScope.Shading(
    isVisible: Boolean,
    color: Color = Color.Black.copy(alpha = 0.2F),
) =
    AnimatedVisibility(
        visible = isVisible,
        modifier = Modifier.matchParentSize(),
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Box(modifier = Modifier.background(color))
    }
