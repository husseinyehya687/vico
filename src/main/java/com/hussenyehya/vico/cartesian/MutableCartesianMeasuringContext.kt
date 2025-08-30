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

package com.hussenyehya.vico.cartesian

import android.graphics.RectF
import androidx.annotation.RestrictTo
import com.hussenyehya.vico.cartesian.data.CartesianChartModel
import com.hussenyehya.vico.cartesian.data.CartesianChartRanges
import com.hussenyehya.vico.cartesian.layer.CartesianLayerPadding
import com.hussenyehya.vico.common.MutableMeasuringContext
import com.hussenyehya.vico.common.Point
import com.hussenyehya.vico.common.data.CacheStore
import com.hussenyehya.vico.common.data.ExtraStore

/** @suppress */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public class MutableCartesianMeasuringContext(
  override val canvasBounds: RectF,
  override var density: Float,
  override var extraStore: ExtraStore,
  override var isLtr: Boolean,
  spToPx: (Float) -> Float,
  override var model: CartesianChartModel,
  override var ranges: CartesianChartRanges,
  override var scrollEnabled: Boolean,
  override var zoomEnabled: Boolean,
  override var layerPadding: CartesianLayerPadding,
  override var pointerPosition: Point?,
  cacheStore: CacheStore = CacheStore(),
) :
  MutableMeasuringContext(canvasBounds, density, extraStore, isLtr, spToPx, cacheStore),
  CartesianMeasuringContext
