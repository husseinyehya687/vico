/*
 * Copyright 2025 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hussenyehya.vico.multiplatform.cartesian.layer

import androidx.compose.ui.graphics.Path
import com.hussenyehya.vico.multiplatform.cartesian.CartesianDrawingContext
import kotlin.math.abs

internal data class CubicPointConnector(private val curvature: Float) :
  LineCartesianLayer.PointConnector {
  init {
    require(curvature > 0 && curvature <= 1) { "`curvature` must be in (0, 1]." }
  }

  override fun connect(
    context: CartesianDrawingContext,
    path: Path,
    x1: Float,
    y1: Float,
    x2: Float,
    y2: Float,
  ) {
    val xDelta =
      (Y_MULTIPLIER * abs(y2 - y1) / context.layerBounds.height).coerceAtMost(1f) *
        curvature *
        (x2 - x1)
    path.cubicTo(x1 + xDelta, y1, x2 - xDelta, y2, x2, y2)
  }

  private companion object {
    const val Y_MULTIPLIER = 4
  }
}
