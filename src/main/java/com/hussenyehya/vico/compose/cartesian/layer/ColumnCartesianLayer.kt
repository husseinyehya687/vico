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

package com.hussenyehya.vico.compose.cartesian.layer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hussenyehya.vico.compose.common.component.rememberLineComponent
import com.hussenyehya.vico.compose.common.fill
import com.hussenyehya.vico.compose.common.vicoTheme
import com.hussenyehya.vico.core.cartesian.axis.Axis
import com.hussenyehya.vico.core.cartesian.data.CartesianLayerRangeProvider
import com.hussenyehya.vico.core.cartesian.data.CartesianValueFormatter
import com.hussenyehya.vico.core.cartesian.data.ColumnCartesianLayerDrawingModel
import com.hussenyehya.vico.core.cartesian.layer.ColumnCartesianLayer
import com.hussenyehya.vico.core.cartesian.layer.ColumnCartesianLayer.MergeMode
import com.hussenyehya.vico.core.common.Defaults
import com.hussenyehya.vico.core.common.Position
import com.hussenyehya.vico.core.common.ValueWrapper
import com.hussenyehya.vico.core.common.component.TextComponent
import com.hussenyehya.vico.core.common.data.CartesianLayerDrawingModelInterpolator
import com.hussenyehya.vico.core.common.data.ExtraStore
import com.hussenyehya.vico.core.common.getValue
import com.hussenyehya.vico.core.common.setValue

/** Creates and remembers a [ColumnCartesianLayer]. */
@Composable
public fun rememberColumnCartesianLayer(
  columnProvider: ColumnCartesianLayer.ColumnProvider =
    ColumnCartesianLayer.ColumnProvider.series(
      vicoTheme.columnCartesianLayerColors.map { color ->
        rememberLineComponent(fill(color), Defaults.COLUMN_WIDTH.dp)
      }
    ),
  columnCollectionSpacing: Dp = Defaults.COLUMN_COLLECTION_SPACING.dp,
  mergeMode: (ExtraStore) -> MergeMode = { MergeMode.grouped() },
  dataLabel: TextComponent? = null,
  dataLabelPosition: Position.Vertical = Position.Vertical.Top,
  dataLabelValueFormatter: CartesianValueFormatter = CartesianValueFormatter.Default,
  dataLabelRotationDegrees: Float = 0f,
  rangeProvider: CartesianLayerRangeProvider = remember { CartesianLayerRangeProvider.auto() },
  verticalAxisPosition: Axis.Position.Vertical? = null,
  drawingModelInterpolator:
    CartesianLayerDrawingModelInterpolator<
      ColumnCartesianLayerDrawingModel.Entry,
      ColumnCartesianLayerDrawingModel,
    > =
    remember {
      CartesianLayerDrawingModelInterpolator.default()
    },
): ColumnCartesianLayer {
  var columnCartesianLayerWrapper by remember { ValueWrapper<ColumnCartesianLayer?>(null) }
  return remember(
    columnProvider,
    columnCollectionSpacing,
    mergeMode,
    dataLabel,
    dataLabelPosition,
    dataLabelValueFormatter,
    dataLabelRotationDegrees,
    rangeProvider,
    verticalAxisPosition,
    drawingModelInterpolator,
  ) {
    val columnCartesianLayer =
      columnCartesianLayerWrapper?.copy(
        columnProvider,
        columnCollectionSpacing.value,
        mergeMode,
        dataLabel,
        dataLabelPosition,
        dataLabelValueFormatter,
        dataLabelRotationDegrees,
        rangeProvider,
        verticalAxisPosition,
        drawingModelInterpolator,
      )
        ?: ColumnCartesianLayer(
          columnProvider,
          columnCollectionSpacing.value,
          mergeMode,
          dataLabel,
          dataLabelPosition,
          dataLabelValueFormatter,
          dataLabelRotationDegrees,
          rangeProvider,
          verticalAxisPosition,
          drawingModelInterpolator,
        )
    columnCartesianLayerWrapper = columnCartesianLayer
    columnCartesianLayer
  }
}

/** Creates a [MergeMode.Grouped] instance. */
public fun MergeMode.Companion.grouped(
  columnSpacing: Dp = Defaults.GROUPED_COLUMN_SPACING.dp
): MergeMode.Grouped = MergeMode.Grouped(columnSpacing.value)

/** Returns a [MergeMode.Stacked] instance. */
public fun MergeMode.Companion.stacked(): MergeMode.Stacked = MergeMode.Stacked
