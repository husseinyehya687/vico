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

package com.hussenyehya.vico.sample

import com.hussenyehya.vico.sample.compose.JetpackComposeAITestScores
import com.hussenyehya.vico.sample.compose.JetpackComposeBasicColumnChart
import com.hussenyehya.vico.sample.compose.JetpackComposeBasicComboChart
import com.hussenyehya.vico.sample.compose.JetpackComposeBasicLineChart
import com.hussenyehya.vico.sample.compose.JetpackComposeDailyDigitalMediaUse
import com.hussenyehya.vico.sample.compose.JetpackComposeElectricCarSales
import com.hussenyehya.vico.sample.compose.JetpackComposeGoldPrices
import com.hussenyehya.vico.sample.compose.JetpackComposeRockMetalRatios
import com.hussenyehya.vico.sample.compose.JetpackComposeTemperatureAnomalies
import com.hussenyehya.vico.sample.views.ViewAITestScores
import com.hussenyehya.vico.sample.views.ViewBasicColumnChart
import com.hussenyehya.vico.sample.views.ViewBasicComboChart
import com.hussenyehya.vico.sample.views.ViewBasicLineChart
import com.hussenyehya.vico.sample.views.ViewDailyDigitalMediaUse
import com.hussenyehya.vico.sample.views.ViewElectricCarSales
import com.hussenyehya.vico.sample.views.ViewGoldPrices
import com.hussenyehya.vico.sample.views.ViewRockMetalRatios
import com.hussenyehya.vico.sample.views.ViewTemperatureAnomalies

actual val Charts.overridden: LinkedHashMap<UIFramework, List<Chart>>?
  get() =
    linkedMapOf(
      UIFramework.JetpackCompose to
        default(
          { JetpackComposeBasicColumnChart(it) },
          { JetpackComposeBasicLineChart(it) },
          { JetpackComposeBasicComboChart(it) },
          { JetpackComposeAITestScores(it) },
          { JetpackComposeDailyDigitalMediaUse(it) },
          { JetpackComposeTemperatureAnomalies(it) },
          { JetpackComposeElectricCarSales(it) },
          { JetpackComposeRockMetalRatios(it) },
          { JetpackComposeGoldPrices(it) },
        ),
      UIFramework.ComposeMultiplatform to ComposeMultiplatform,
      UIFramework.Views to
        default(
          { ViewBasicColumnChart(it) },
          { ViewBasicLineChart(it) },
          { ViewBasicComboChart(it) },
          { ViewAITestScores(it) },
          { ViewDailyDigitalMediaUse(it) },
          { ViewTemperatureAnomalies(it) },
          { ViewElectricCarSales(it) },
          { ViewRockMetalRatios(it) },
          { ViewGoldPrices(it) },
        ),
    )
