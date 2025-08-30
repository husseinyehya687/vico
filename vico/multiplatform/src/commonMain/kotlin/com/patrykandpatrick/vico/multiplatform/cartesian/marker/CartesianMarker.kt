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

package com.hussenyehya.vico.multiplatform.cartesian.marker

import androidx.compose.runtime.Immutable
import com.hussenyehya.vico.multiplatform.cartesian.CartesianChart
import com.hussenyehya.vico.multiplatform.cartesian.CartesianDrawingContext
import com.hussenyehya.vico.multiplatform.cartesian.data.CartesianChartModel
import com.hussenyehya.vico.multiplatform.cartesian.layer.CartesianLayer
import com.hussenyehya.vico.multiplatform.cartesian.layer.CartesianLayerMarginUpdater

/** Marks [CartesianChart] objects. */
@Immutable
public interface CartesianMarker : CartesianLayerMarginUpdater<CartesianChartModel> {
  /** Draws content under the [CartesianLayer]s. */
  public fun drawUnderLayers(context: CartesianDrawingContext, targets: List<Target>) {}

  /** Draws content over the [CartesianLayer]s. */
  public fun drawOverLayers(context: CartesianDrawingContext, targets: List<Target>) {}

  /** Houses information on an object to be marked. */
  public interface Target {
    /** The _x_ value. */
    public val x: Double

    /** The pixel _x_ coordinate. */
    public val canvasX: Float
  }
}
