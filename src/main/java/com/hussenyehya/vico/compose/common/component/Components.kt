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
@file:Suppress("DeprecatedCallableAddReplaceWith")

package com.hussenyehya.vico.compose.common.component

import android.graphics.Typeface
import android.text.Layout
import android.text.TextUtils
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hussenyehya.vico.compose.common.pixelSize
import com.hussenyehya.vico.core.common.Defaults
import com.hussenyehya.vico.core.common.Fill
import com.hussenyehya.vico.core.common.Insets
import com.hussenyehya.vico.core.common.component.Component
import com.hussenyehya.vico.core.common.component.LineComponent
import com.hussenyehya.vico.core.common.component.Shadow
import com.hussenyehya.vico.core.common.component.ShapeComponent
import com.hussenyehya.vico.core.common.component.TextComponent
import com.hussenyehya.vico.core.common.shape.Shape

/** Creates and remembers a [LineComponent]. */
@Composable
public fun rememberLineComponent(
  fill: Fill = Fill.Black,
  thickness: Dp = Defaults.LINE_COMPONENT_THICKNESS_DP.dp,
  shape: Shape = Shape.Rectangle,
  margins: Insets = Insets.Zero,
  strokeFill: Fill = Fill.Transparent,
  strokeThickness: Dp = 0.dp,
  shadow: Shadow? = null,
): LineComponent =
  remember(fill, shape, thickness, margins, strokeFill, strokeThickness, shadow) {
    LineComponent(fill, thickness.value, shape, margins, strokeFill, strokeThickness.value, shadow)
  }

/** Creates a [ShapeComponent]. */
public fun shapeComponent(
  fill: Fill = Fill.Black,
  shape: Shape = Shape.Rectangle,
  margins: Insets = Insets.Zero,
  strokeFill: Fill = Fill.Transparent,
  strokeThickness: Dp = 0.dp,
  shadow: Shadow? = null,
): ShapeComponent = ShapeComponent(fill, shape, margins, strokeFill, strokeThickness.value, shadow)

/** Creates and remembers a [ShapeComponent]. */
@Composable
public fun rememberShapeComponent(
  fill: Fill = Fill.Black,
  shape: Shape = Shape.Rectangle,
  margins: Insets = Insets.Zero,
  strokeFill: Fill = Fill.Transparent,
  strokeThickness: Dp = 0.dp,
  shadow: Shadow? = null,
): ShapeComponent =
  remember(fill, shape, margins, strokeFill, strokeThickness, shadow) {
    shapeComponent(fill, shape, margins, strokeFill, strokeThickness, shadow)
  }

/** Creates and remembers a [TextComponent]. */
@Composable
public fun rememberTextComponent(
  color: Color = Color.Black,
  typeface: Typeface = Typeface.DEFAULT,
  textSize: TextUnit = Defaults.TEXT_COMPONENT_TEXT_SIZE.sp,
  textAlignment: Layout.Alignment = Layout.Alignment.ALIGN_NORMAL,
  lineHeight: TextUnit? = null,
  lineCount: Int = Defaults.TEXT_COMPONENT_LINE_COUNT,
  truncateAt: TextUtils.TruncateAt = TextUtils.TruncateAt.END,
  margins: Insets = Insets.Zero,
  padding: Insets = Insets.Zero,
  background: Component? = null,
  minWidth: TextComponent.MinWidth = TextComponent.MinWidth.fixed(),
): TextComponent =
  remember(
    color,
    typeface,
    textSize,
    textAlignment,
    lineHeight,
    lineCount,
    truncateAt,
    margins,
    padding,
    background,
    minWidth,
  ) {
    TextComponent(
      color.toArgb(),
      typeface,
      textSize.pixelSize(),
      textAlignment,
      lineHeight?.pixelSize(),
      lineCount,
      truncateAt,
      margins,
      padding,
      background,
      minWidth,
    )
  }

/** Creates a [Shadow]. */
public fun shadow(radius: Dp, x: Dp = 0.dp, y: Dp = 0.dp, color: Color? = null): Shadow =
  Shadow(radius.value, x.value, y.value, color?.toArgb() ?: Defaults.SHADOW_COLOR)

/** A [Dp] version of [TextComponent.MinWidth.fixed]. */
public fun TextComponent.MinWidth.Companion.fixed(value: Dp = 0.dp): TextComponent.MinWidth =
  fixed(value.value)
