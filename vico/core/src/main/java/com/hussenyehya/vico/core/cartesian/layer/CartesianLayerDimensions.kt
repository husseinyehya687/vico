/*
 * Copyright 2024 by Patryk Goworowski and Patrick Michalik.
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

package com.hussenyehya.vico.core.cartesian.layer

import com.hussenyehya.vico.core.cartesian.CartesianMeasuringContext

/** Stores shared [CartesianLayer] dimensions. */
public interface CartesianLayerDimensions {
  /** The distance between neighboring major _x_ values (in pixels). This can be scaled. */
  public val xSpacing: Float

  /**
   * The scalable part of the distance between the start of the content area and the first entry (in
   * pixels).
   */
  public val scalableStartPadding: Float

  /**
   * The scalable part of the distance between the end of the content area and the last entry (in
   * pixels).
   */
  public val scalableEndPadding: Float

  /**
   * The unscalable part of the distance between the start of the content area and the first entry
   * (in pixels).
   */
  public val unscalableStartPadding: Float

  /**
   * The unscalable part of the distance between the end of the content area and the last entry (in
   * pixels).
   */
  public val unscalableEndPadding: Float

  /** The total start padding (in pixels). */
  public val startPadding: Float
    get() = scalableStartPadding + unscalableStartPadding

  /** The total end padding (in pixels). */
  public val endPadding: Float
    get() = scalableEndPadding + unscalableEndPadding

  /** The total scalable horizontal padding (in pixels). */
  public val scalablePadding: Float
    get() = scalableStartPadding + scalableEndPadding

  /** The total unscalable horizontal padding (in pixels). */
  public val unscalablePadding: Float
    get() = unscalableStartPadding + unscalableEndPadding

  /** The total horizontal padding (in pixels). */
  public val padding: Float
    get() = startPadding + endPadding

  /** Calculates the width of the [CartesianChart]’s scalable content (in pixels). */
  public fun getScalableContentWidth(context: CartesianMeasuringContext): Float =
    with(context) { xSpacing * (ranges.xLength / ranges.xStep).toFloat() + scalablePadding }

  /** Calculates the width of the [CartesianChart]’s content (in pixels). */
  public fun getContentWidth(context: CartesianMeasuringContext): Float =
    getScalableContentWidth(context) + unscalablePadding
}
