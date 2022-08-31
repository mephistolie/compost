package com.mephistolie.compost.modifiers

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.semantics.Role

/**
 * Configure component to receive clicks without ripple effect and extra args.
 *
 * @param debounceInterval minimum interval between two successful clicks. If null, standard clickable
 * will be used
 * @param onClick will be called when user clicks on the element
 */
fun Modifier.simpleClickable(
    debounceInterval: Long? = null,
    onClick: () -> Unit,
): Modifier = composed {
    debounceClickable(
        debounceInterval = debounceInterval,
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = null
    )
}

/**
 * Configure component to receive clicks with size changing on press.
 *
 * @param scaleFactor size change factor
 * @param debounceInterval minimum interval between two successful clicks. If null, standard clickable
 * will be used
 * @param onClick will be called when user clicks on the element
 */
fun Modifier.scalingClickable(
    scaleFactor: Float = 0.975F,
    debounceInterval: Long? = null,
    onClick: () -> Unit,
): Modifier = composed {
    scalingClickable(
        pressed = remember { mutableStateOf(false) },
        scaleFactor = scaleFactor,
        debounceInterval = debounceInterval,
        onClick = onClick,
    )
}

/**
 * Configure component to receive clicks with size changing on press.
 *
 * @param pressed defines is button pressed
 * @param scaleFactor size change factor
 * @param debounceInterval minimum interval between two successful clicks. If null, standard clickable
 * will be used
 * @param onClick will be called when user clicks on the element
 */
@OptIn(ExperimentalComposeUiApi::class)
@Suppress("LabeledExpression")
fun Modifier.scalingClickable(
    pressed: MutableState<Boolean>,
    scaleFactor: Float = 0.975F,
    debounceInterval: Long? = null,
    onClick: () -> Unit,
): Modifier = composed {
    var lastClickTime by remember { mutableStateOf(0L) }

    val scale = animateFloatAsState(if (!pressed.value) 1F else scaleFactor)

    this
        .scale(scale.value)
        .pointerInteropFilter {
            if (debounceInterval != null) {
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastClickTime < debounceInterval) {
                    pressed.value = false
                    return@pointerInteropFilter true
                }
                lastClickTime = currentTime
            }
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

/**
 * Configure component to set the interval between successful clicks.
 *
 * @param enabled Controls the enabled state. When `false`, [onClick], and this modifier will
 * appear disabled for accessibility services
 * @param onClickLabel semantic / accessibility label for the [onClick] action
 * @param role the type of user interface element. Accessibility services might use this
 * to describe the element or do customizations
 * @param debounceInterval minimum interval between two successful clicks. If null, standard clickable
 * will be used
 * @param onClick will be called when the element is successfully clicked
 **/
fun Modifier.debounceClickable(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    debounceInterval: Long? = 500L,
    onClick: () -> Unit,
): Modifier = composed {
    debounceClickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = LocalIndication.current,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        debounceInterval = debounceInterval,
        onClick = onClick,
    )
}

/**
 * Configure component to set the interval between successful clicks.

 * @param interactionSource [MutableInteractionSource] that will be used to dispatch
 * [PressInteraction.Press] when this clickable is pressed. Only the initial (first) press will be
 * recorded and dispatched with [MutableInteractionSource].
 * @param indication indication to be shown when modified element is pressed. Be default,
 * indication from [LocalIndication] will be used. Pass `null` to show no indication, or
 * current value from [LocalIndication] to show theme default
 * @param enabled Controls the enabled state. When `false`, [onClick], and this modifier will
 * appear disabled for accessibility services
 * @param onClickLabel semantic / accessibility label for the [onClick] action
 * @param role the type of user interface element. Accessibility services might use this
 * to describe the element or do customizations
 * @param debounceInterval minimum interval between two successful clicks. If null, standard clickable
 * will be used
 * @param onClick will be called when the element is successfully clicked
 **/
@Suppress("LabeledExpression")
fun Modifier.debounceClickable(
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    debounceInterval: Long? = 500L,
    onClick: () -> Unit,
): Modifier = composed {
    var lastClickTime by remember { mutableStateOf(0L) }
    clickable(
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role
    ) {
        if (debounceInterval != null) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime < debounceInterval) return@clickable
            lastClickTime = currentTime
        }
        onClick()
    }
}
