# Vico Library Usage Example

## Import the Library

```kotlin
// Add to your app's build.gradle
dependencies {
    implementation 'com.github.husseinyehya687:vico:3.0.5'
    // OR if using locally:
    // implementation 'com.hussenyehya.vico:vico:3.0.5'
}
```

## Basic Usage

```kotlin
import com.hussenyehya.vico.cartesian.CartesianChart
import com.hussenyehya.vico.cartesian.data.CartesianChartModel
import com.hussenyehya.vico.cartesian.layer.ColumnCartesianLayer
import com.hussenyehya.vico.common.component.TextComponent

// Example: Create a simple column chart
class MyActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Create chart data
        val chartModel = CartesianChartModel.Builder()
            // Add your data here
            .build()
        
        // Create column layer
        val columnLayer = ColumnCartesianLayer.Builder()
            .build()
        
        // Create chart
        val chart = CartesianChart.Builder()
            .addLayer(columnLayer)
            .build()
        
        // Use the chart in your view...
    }
}
```

## Available Classes

The library exposes these main packages:
- `com.hussenyehya.vico.cartesian.*` - Chart components and layers
- `com.hussenyehya.vico.common.*` - Common utilities and components

## Key Classes

- `CartesianChart` - Main chart class
- `ColumnCartesianLayer` - For column/bar charts  
- `LineCartesianLayer` - For line charts
- `CartesianChartModel` - Chart data model
- `TextComponent` - Text rendering component