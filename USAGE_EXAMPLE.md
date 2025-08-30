# Vico Library Usage Example

## Import the Library

```kotlin
// Add to your app's build.gradle
dependencies {
    implementation 'com.github.husseinyehya687:vico:3.0.6'
    // OR if using locally:
    // implementation 'com.hussenyehya.vico:vico:3.0.6'
}
```

## Basic Usage

### Compose Usage
```kotlin
import com.hussenyehya.vico.compose.cartesian.CartesianChartHost
import com.hussenyehya.vico.compose.cartesian.layer.rememberColumnCartesianLayer
import com.hussenyehya.vico.core.cartesian.data.CartesianChartModel

@Composable
fun MyChart() {
    val cartesianChartModel = remember { 
        // Create your chart model here
        CartesianChartModel.Builder().build()
    }
    
    CartesianChartHost(
        chart = CartesianChart(
            layers = listOf(rememberColumnCartesianLayer())
        ),
        modelProducer = cartesianChartModel,
    )
}
```

### Views Usage  
```kotlin
import com.hussenyehya.vico.views.cartesian.CartesianChartView
import com.hussenyehya.vico.core.cartesian.layer.ColumnCartesianLayer

class MyActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val chartView = CartesianChartView(this)
        
        // Configure the chart
        chartView.chart = CartesianChart.Builder()
            .addLayer(ColumnCartesianLayer.Builder().build())
            .build()
    }
}
```

## Available Packages

- **Core**: `com.hussenyehya.vico.core.*` - Chart logic, data models, drawing
- **Compose**: `com.hussenyehya.vico.compose.*` - Jetpack Compose integration  
- **Views**: `com.hussenyehya.vico.views.*` - Traditional Android Views
- **Common**: `com.hussenyehya.vico.common.*` - Shared utilities

## Key Classes by Module

### Core Module
- `CartesianChart` - Main chart class
- `ColumnCartesianLayer` - For column/bar charts  
- `LineCartesianLayer` - For line charts
- `CartesianChartModel` - Chart data model

### Compose Module  
- `CartesianChartHost` - Compose chart container
- `rememberColumnCartesianLayer()` - Compose column layer
- `rememberLineCartesianLayer()` - Compose line layer

### Views Module
- `CartesianChartView` - Android View chart component