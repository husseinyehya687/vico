# 🚀 JitPack Publishing Guide for Vico Enhanced SDK

## Overview
This guide shows you how to publish your enhanced Vico SDK to JitPack so users can import it with the simplified syntax: 
```kotlin
implementation("com.github.husseinyehya687:vico:v1.0.0")
```

---

## ✅ Prerequisites (Already Completed)

The following setup has already been done:

1. **✅ Root build.gradle.kts**: Created unified Android library module
2. **✅ Maven Publishing**: Configured proper publishing metadata  
3. **✅ Single Variant**: Set up release variant with sources and javadoc
4. **✅ Compose Compiler**: Fixed Kotlin 2.0 compatibility
5. **✅ Version Configuration**: Set to v1.0.0 in Versions.kt
6. **✅ Project Structure**: Updated settings.gradle.kts for JitPack compatibility

---

## 🎯 Publishing Steps

### Step 1: Commit Your Changes
```bash
# Add all changes
git add .

# Commit with descriptive message
git commit -m "Configure JitPack single-artifact publishing

- Add root-level Android library module that aggregates all Vico modules
- Configure Maven publishing with proper metadata for JitPack
- Set up single release variant with sources and javadoc
- Update Compose Compiler plugin for Kotlin 2.0 compatibility
- Set version to v1.0.0 for stable release
- Enable simplified import syntax: implementation 'com.github.husseinyehya687:vico:v1.0.0'"
```

### Step 2: Create and Push Git Tag
```bash
# Create annotated tag for v1.0.0
git tag -a v1.0.0 -m "Release v1.0.0: Enhanced Vico with Column Click Functionality

🎉 Features:
- Interactive column click detection for charts
- Dynamic column styling and color changes  
- Compose and Views integration
- Material Design 2 & 3 support
- Simplified single-dependency import

📦 Import:
implementation 'com.github.husseinyehya687:vico:v1.0.0'

🔧 Technical:
- JitPack single-artifact publishing
- Unified module aggregation
- Kotlin 2.0 & Compose Compiler compatibility
- Maven publishing with sources & javadoc"

# Push the tag to GitHub
git push origin v1.0.0

# Also push main branch if needed
git push origin main
```

### Step 3: Trigger JitPack Build
1. Go to: **https://jitpack.io/#husseinyehya687/vico**
2. Click **"Look Up"** to refresh the repository
3. Find version **v1.0.0** in the list
4. Click the **"Get it"** button next to v1.0.0
5. Wait for JitPack to build (this may take 5-15 minutes)

### Step 4: Monitor Build Status
JitPack will show one of these statuses:
- 🔄 **Building**: JitPack is compiling your project
- ✅ **OK**: Build successful, ready to use!
- ❌ **ERROR**: Build failed, check logs

If the build fails:
1. Click on the **Log** link to see error details
2. Fix any issues in your code
3. Create a new tag (e.g., v1.0.1) and repeat

### Step 5: Test the Import
Create a test project and add:

```kotlin
// settings.gradle.kts or build.gradle.kts (project level)
repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

// app/build.gradle.kts
dependencies {
    implementation("com.github.husseinyehya687:vico:v1.0.0")
    
    // Compose dependencies if not already included
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.material3:material3:1.1.2")
}
```

---

## 🔧 Build Configuration Details

### What Makes This Work?

#### 1. **Root Android Library Module**
```kotlin
// Root build.gradle.kts creates a library that includes all sub-modules
dependencies {
    api(project(":vico:core"))        // Chart logic and models
    api(project(":vico:compose"))     // Compose integration  
    api(project(":vico:compose-m2"))  // Material Design 2
    api(project(":vico:compose-m3"))  // Material Design 3
    api(project(":vico:views"))       // Traditional Android Views
}
```

#### 2. **Single Release Variant**
```kotlin
android {
    publishing {
        singleVariant("release") {
            withSourcesJar()    // Include source code
            withJavadocJar()    // Include documentation
        }
    }
}
```

#### 3. **Maven Publishing Configuration**
```kotlin
publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["release"])
            groupId = "com.patrykandpatrick.vico"
            artifactId = "vico"           // Single artifact name
            version = "1.0.0"
        }
    }
}
```

---

## 🎯 JitPack URL Structure

After successful build, your SDK will be available at:

### Primary Artifact (Recommended)
```kotlin
implementation("com.github.husseinyehya687:vico:v1.0.0")
```

### Individual Modules (Advanced)
```kotlin
implementation("com.github.husseinyehya687.vico:core:v1.0.0")
implementation("com.github.husseinyehya687.vico:compose:v1.0.0")
implementation("com.github.husseinyehya687.vico:views:v1.0.0")
```

---

## 🚨 Troubleshooting

### Build Fails on JitPack
1. **Check Java/Kotlin compatibility**
   - JitPack uses Java 17 by default
   - Your project targets Java 1.8 - this should be fine

2. **Missing dependencies**
   - All required Compose libraries are included as `implementation`
   - Sub-modules are properly referenced with `api`

3. **Build timeout**
   - JitPack has a 15-minute build limit
   - Complex projects may need optimization

### Import Issues
1. **Repository not found**
   ```kotlin
   // Make sure to add JitPack repository
   maven { url = uri("https://jitpack.io") }
   ```

2. **Version not available**
   - Check that the git tag exists: `git tag -l`
   - Verify JitPack build was successful
   - Try rebuilding on JitPack website

3. **Dependency resolution errors**
   - Make sure your `minSdk` (21) is compatible
   - Check that Compose versions match

---

## 📋 Version Release Checklist

Before creating a new release:

- [ ] All tests pass locally
- [ ] Version number updated in `Versions.kt`
- [ ] Documentation updated
- [ ] Changes committed to main branch
- [ ] Git tag created with proper annotation
- [ ] Tag pushed to GitHub
- [ ] JitPack build successful
- [ ] Test import in sample project
- [ ] Update README with new version

---

## 🎉 Success Indicators

You'll know everything is working when:

1. **JitPack shows "OK" status** for your version
2. **Import resolves without errors** in Android Studio
3. **All Vico modules are accessible** with single import:
   ```kotlin
   import com.patrykandpatrick.vico.core.cartesian.layer.ColumnCartesianLayer
   import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
   import com.patrykandpatrick.vico.compose.cartesian.layer.rememberColumnCartesianLayer
   ```
4. **Column click functionality works** in test app
5. **Build gradle sync succeeds** without warnings

---

## 🔗 Useful Links

- **JitPack Dashboard**: https://jitpack.io/#husseinyehya687/vico
- **GitHub Repository**: https://github.com/husseinyehya687/vico  
- **JitPack Docs**: https://jitpack.io/docs/
- **Android Publishing Guide**: https://developer.android.com/studio/build/maven-publish-plugin

---

## 📞 Next Steps After Publishing

1. **Update Documentation**: Ensure all guides reference the new import syntax
2. **Create Release Notes**: Document new features and changes
3. **Test Integration**: Verify in multiple project types
4. **Community Notification**: Announce the simplified import to users
5. **Monitor Issues**: Watch for integration problems or feedback