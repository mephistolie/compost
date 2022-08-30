package com.mephistolie.compost.modifiers

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.util.Log
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp


fun Modifier.blurCompat(
    radiusX: Dp,
    radiusY: Dp,
    edgeTreatment: BlurredEdgeTreatment = BlurredEdgeTreatment.Rectangle,
): Modifier =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        blur(
            radiusX = radiusX,
            radiusY = radiusY,
            edgeTreatment = edgeTreatment,
        )
    } else {
        onGloballyPositioned {
            this
                .composed {
                    val context = LocalContext.current
                    val view = LocalView.current

                    val renderScript = remember { RenderScript.create(context) }

                    val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
                    val canvas = Canvas(bitmap)
                    view.background?.draw(canvas)
                    view.draw(canvas)

                    val inAllocation = Allocation.createFromBitmap(renderScript, bitmap)

                    val outAllocation = Allocation.createTyped(renderScript, inAllocation.getType());
                    val blurScript = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));

                    blurScript.setRadius(20F)
                    blurScript.setInput(inAllocation)

                    blurScript.forEach(outAllocation)
                    outAllocation.copyTo(bitmap)

                    Log.e("BLUR TEST", bitmap.toString())
                    this
                }
        }
    }
