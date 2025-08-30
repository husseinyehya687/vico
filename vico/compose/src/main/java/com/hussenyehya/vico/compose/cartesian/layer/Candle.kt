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

package com.hussenyehya.vico.compose.cartesian.layer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.alpha
import com.hussenyehya.vico.compose.common.component.rememberLineComponent
import com.hussenyehya.vico.compose.common.fill
import com.hussenyehya.vico.compose.common.vicoTheme
import com.hussenyehya.vico.core.cartesian.layer.CandlestickCartesianLayer
import com.hussenyehya.vico.core.cartesian.layer.CandlestickCartesianLayer.Candle
import com.hussenyehya.vico.core.cartesian.layer.absolute
import com.hussenyehya.vico.core.cartesian.layer.absoluteRelative
import com.hussenyehya.vico.core.common.Defaults
import com.hussenyehya.vico.core.common.Fill
import com.hussenyehya.vico.core.common.component.LineComponent

@Composable
private fun Candle.Companion.sharpFilledCandle(
  color: Color,
  thickness: Dp = Defaults.CANDLE_BODY_WIDTH_DP.dp,
) = Candle(rememberLineComponent(fill(color), thickness))

@Composable
private fun Candle.Companion.sharpHollowCandle(
  color: Color,
  thickness: Dp = Defaults.CANDLE_BODY_WIDTH_DP.dp,
  strokeThickness: Dp = Defaults.HOLLOW_CANDLE_STROKE_THICKNESS_DP.dp,
) =
  Candle(
    rememberLineComponent(
      fill = Fill.Transparent,
      thickness = thickness,
      strokeFill = fill(color),
      strokeThickness = strokeThickness,
    )
  )

private fun Candle.copyWithColor(color: Color) =
  Candle(body.copyWithColor(color), topWick.copyWithColor(color), bottomWick.copyWithColor(color))

private fun LineComponent.copyWithColor(color: Color) =
  copy(
    fill = if (fill.color.alpha == 0) fill else fill(color),
    strokeFill = if (strokeFill.color.alpha == 0) strokeFill else fill(color),
  )

/**
 * An alias for [CandlestickCartesianLayer.CandleProvider.Companion.absolute] with default
 * arguments.
 */
@Composable
@Stable
public fun CandlestickCartesianLayer.CandleProvider.Companion.absolute(
  bullish: Candle = Candle.sharpFilledCandle(vicoTheme.candlestickCartesianLayerColors.bullish),
  neutral: Candle = bullish.copyWithColor(vicoTheme.candlestickCartesianLayerColors.neutral),
  bearish: Candle = bullish.copyWithColor(vicoTheme.candlestickCartesianLayerColors.bearish),
): CandlestickCartesianLayer.CandleProvider =
  CandlestickCartesianLayer.CandleProvider.absolute(bullish, neutral, bearish)

/**
 * An alias for [CandlestickCartesianLayer.CandleProvider.Companion.absoluteRelative] with default
 * arguments.
 */
@Composable
@Stable
public fun CandlestickCartesianLayer.CandleProvider.Companion.absoluteRelative(
  absolutelyBullishRelativelyBullish: Candle =
    Candle.sharpHollowCandle(vicoTheme.candlestickCartesianLayerColors.bullish),
  absolutelyBullishRelativelyNeutral: Candle =
    absolutelyBullishRelativelyBullish.copyWithColor(
      vicoTheme.candlestickCartesianLayerColors.neutral
    ),
  absolutelyBullishRelativelyBearish: Candle =
    absolutelyBullishRelativelyBullish.copyWithColor(
      vicoTheme.candlestickCartesianLayerColors.bearish
    ),
  absolutelyNeutralRelativelyBullish: Candle = absolutelyBullishRelativelyBullish,
  absolutelyNeutralRelativelyNeutral: Candle = absolutelyBullishRelativelyNeutral,
  absolutelyNeutralRelativelyBearish: Candle = absolutelyBullishRelativelyBearish,
  absolutelyBearishRelativelyBullish: Candle =
    Candle.sharpFilledCandle(vicoTheme.candlestickCartesianLayerColors.bullish),
  absolutelyBearishRelativelyNeutral: Candle =
    absolutelyBearishRelativelyBullish.copyWithColor(
      vicoTheme.candlestickCartesianLayerColors.neutral
    ),
  absolutelyBearishRelativelyBearish: Candle =
    absolutelyBearishRelativelyBullish.copyWithColor(
      vicoTheme.candlestickCartesianLayerColors.bearish
    ),
): CandlestickCartesianLayer.CandleProvider =
  CandlestickCartesianLayer.CandleProvider.absoluteRelative(
    absolutelyBullishRelativelyBullish,
    absolutelyBullishRelativelyNeutral,
    absolutelyBullishRelativelyBearish,
    absolutelyNeutralRelativelyBullish,
    absolutelyNeutralRelativelyNeutral,
    absolutelyNeutralRelativelyBearish,
    absolutelyBearishRelativelyBullish,
    absolutelyBearishRelativelyNeutral,
    absolutelyBearishRelativelyBearish,
  )
