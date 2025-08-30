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

package com.hussenyehya.vico.common

import android.graphics.RectF
import androidx.annotation.RestrictTo
import com.hussenyehya.vico.common.data.CacheStore
import com.hussenyehya.vico.common.data.ExtraStore

/** @suppress */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public open class MutableMeasuringContext(
  override val canvasBounds: RectF,
  override var density: Float,
  override val extraStore: ExtraStore,
  override var isLtr: Boolean,
  private var spToPx: (Float) -> Float,
  override val cacheStore: CacheStore = CacheStore(),
) : MeasuringContext {
  override fun spToPx(sp: Float): Float = spToPx.invoke(sp)
}
