# Vico Library v3.0.6 - Quick Start Guide

## 🚀 Get Started Immediately 

Since JitPack builds are having issues, here are **proven working alternatives** to use your complete Vico library:

---

## 📦 Option 1: Local Maven (Recommended for Development)

### Step 1: Publish Locally
```bash
cd /path/to/vico
./gradlew publishToMavenLocal
```

### Step 2: Use in Your Project
```kotlin
// In your project's build.gradle (project level)
repositories {
    mavenLocal()  // Add this first
    google()
    mavenCentral()
}

// In your app's build.gradle  
dependencies {
    implementation("com.hussenyehya.vico:vico:3.0.6")
}
```

### Step 3: Import and Use
```kotlin
// Compose Usage
import com.hussenyehya.vico.compose.cartesian.CartesianChartHost
import com.hussenyehya.vico.compose.cartesian.layer.rememberColumnCartesianLayer

@Composable
fun MyChart() {
    CartesianChartHost(
        chart = CartesianChart(
            layers = listOf(rememberColumnCartesianLayer())
        )
        // ... your chart configuration
    )
}

// Views Usage  
import com.hussenyehya.vico.views.cartesian.CartesianChartView

val chartView = CartesianChartView(context)
// Configure your chart...
```

---

## 🌐 Option 2: GitHub Packages (For Teams/Distribution)

### Step 1: Generate GitHub Token
1. Go to GitHub → Settings → Developer settings → Personal access tokens
2. Generate token with `write:packages` and `read:packages` 
3. Save the token

### Step 2: Publish to GitHub Packages
```bash
export USERNAME=husseinyehya687  
export TOKEN=your_github_token
./gradlew publish
```

### Step 3: Use in External Projects
```kotlin
// In build.gradle (project level)
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/husseinyehya687/vico")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")  
            password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
        }
    }
}

// In build.gradle (app level)
dependencies {
    implementation("com.hussenyehya.vico:vico:3.0.6")
}
```

---

## 📱 What You Get

✅ **Complete Core Module**: All chart types, data models, drawing system  
✅ **Full Compose Integration**: `CartesianChartHost`, `rememberColumnCartesianLayer()`, etc.  
✅ **Complete Views Module**: `CartesianChartView` and traditional Android Views  
✅ **Material Design**: Both M2 and M3 theme support  
✅ **300+ Source Files**: Complete functionality  

---

## 🔧 Available Classes

### Core
- `com.hussenyehya.vico.core.cartesian.CartesianChart`  
- `com.hussenyehya.vico.core.cartesian.layer.ColumnCartesianLayer`
- `com.hussenyehya.vico.core.cartesian.layer.LineCartesianLayer`

### Compose  
- `com.hussenyehya.vico.compose.cartesian.CartesianChartHost`
- `com.hussenyehya.vico.compose.cartesian.layer.rememberColumnCartesianLayer`  
- `com.hussenyehya.vico.compose.cartesian.layer.rememberLineCartesianLayer`

### Views
- `com.hussenyehya.vico.views.cartesian.CartesianChartView`

---

## ⚡ Fastest Setup (1 minute)

```bash
# 1. Publish locally
./gradlew publishToMavenLocal

# 2. Add to your project's build.gradle
repositories { mavenLocal(); google(); mavenCentral() }

# 3. Add dependency  
implementation("com.hussenyehya.vico:vico:3.0.6")

# 4. Import and use!
import com.hussenyehya.vico.compose.cartesian.CartesianChartHost
```

**Your complete Vico library is ready to use!** 🎉