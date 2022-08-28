package com.mephistolie.compost.modifiers

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter

/**
 * Configure component to receive clicks without ripple effect and extra args.
 *
 * @param onClick will be called when user clicks on the element
 */
fun Modifier.simpleClickable(
    onClick: () -> Unit,
): Modifier = composed {
    clickable(
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = null
    )
}

/**
 * Configure component to receive clicks with size changing on press.
 *
 * @param pressed defines is button pressed
 * @param scaleFactor size change factor
 * @param onClick will be called when user clicks on the element
 */
@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.scalingClickable(
    pressed: MutableState<Boolean>,
    scaleFactor: Float = 0.975F,
    onClick: () -> Unit,
): Modifier = composed {

    val scale = animateFloatAsState(if (!pressed.value) 1F else scaleFactor)

    scale(scale.value)
    pointerInteropFilter {
        when (it.action) {
            MotionEvent.ACTION_DOWN -> pressed.value = true
            MotionEvent.ACTION_CANCEL -> pressed.value = false
            MotionEvent.ACTION_UP -> {
                onClick()
                pressed.value = false
            }
        }
        true
    }
}

/**
 * Configure component to receive clicks with size changing on press.
 *
 * @param scaleFactor size change factor
 * @param onClick will be called when user clicks on the element
 */
fun Modifier.scalingClickable(
    scaleFactor: Float = 0.975F,
    onClick: () -> Unit,
): Modifier = composed {
    scalingClickable(
        pressed = remember { mutableStateOf(false) },
        scaleFactor = scaleFactor,
        onClick = onClick
    )
}
