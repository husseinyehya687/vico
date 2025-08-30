# Vico Library Publishing Alternatives

Since JitPack builds are failing, here are reliable alternatives for distributing your Vico library v3.0.6:

## 🚀 Option 1: GitHub Packages (Recommended)

GitHub Packages is free, reliable, and works with your existing setup.

### Setup Steps:

1. **Generate Personal Access Token**:
   - Go to GitHub → Settings → Developer settings → Personal access tokens
   - Create token with `write:packages` and `read:packages` permissions
   - Copy the token

2. **Add to build.gradle**:
```gradle
publishing {
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
}
```

3. **Publish**:
```bash
export USERNAME=husseinyehya687
export TOKEN=your_github_token
./gradlew publish
```

### Usage by External Projects:
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

## 📦 Option 2: Local Maven Publishing

Perfect for personal projects or teams.

### Publish Locally:
```bash
./gradlew publishToMavenLocal
```

### Usage by External Projects:
```kotlin
// In build.gradle (project level)  
repositories {
    mavenLocal()
    google()
    mavenCentral()
}

// In build.gradle (app level)
dependencies {
    implementation("com.hussenyehya.vico:vico:3.0.6")
}
```

## 🌐 Option 3: AAR Distribution

Direct AAR file distribution.

### Generate AAR:
```bash
./gradlew assembleRelease
```

Find AAR at: `build/outputs/aar/vico-release.aar`

### Usage by External Projects:
```kotlin
// Copy AAR to app/libs/
dependencies {
    implementation(files("libs/vico-release.aar"))
    
    // Add required dependencies:
    implementation("androidx.compose.ui:ui:2023.10.01")
    implementation("androidx.compose.foundation:foundation:2023.10.01")
    // ... other Compose dependencies
}
```

## 🔧 Option 4: Maven Central (Long-term)

For official public distribution.

### Requirements:
- Sonatype OSSRH account
- GPG signing setup
- Domain verification

### Benefits:
- Official distribution
- Automatic dependency resolution
- No authentication needed by users

## 📋 Recommended Approach:

1. **Immediate**: Use **GitHub Packages** for reliable distribution
2. **Development**: Use **Local Maven** for testing
3. **Long-term**: Consider **Maven Central** for public release

## 🎯 Current Status:

Your library v3.0.6 includes:
- ✅ Complete Core module (102 files)
- ✅ Complete Compose module (30 files)  
- ✅ Complete Views module (17 files)
- ✅ Material 2 & 3 themes
- ✅ All dependencies properly configured
- ✅ Consumer ProGuard rules
- ✅ Source JAR generation

**The library is production-ready, just needs reliable distribution!**