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

package com.hussenyehya.vico.sample.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.hussenyehya.vico.core.cartesian.data.CartesianChartModelProducer
import com.hussenyehya.vico.core.cartesian.data.lineSeries
import com.hussenyehya.vico.sample.views.databinding.BasicLineChartBinding

@Composable
fun ViewBasicLineChart(modifier: Modifier) {
  val modelProducer = remember { CartesianChartModelProducer() }
  LaunchedEffect(Unit) {
    modelProducer.runTransaction {
      // Learn more: https://patrykandpatrick.com/vmml6t.
      lineSeries { series(13, 8, 7, 12, 0, 1, 15, 14, 0, 11, 6, 12, 0, 11, 12, 11) }
    }
  }
  AndroidViewBinding(
    { inflater, parent, attachToParent ->
      BasicLineChartBinding.inflate(inflater, parent, attachToParent).apply {
        chartView.modelProducer = modelProducer
      }
    },
    modifier,
  )
}
