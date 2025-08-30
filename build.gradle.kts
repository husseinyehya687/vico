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

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.patrykandpatrick.vico"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {
    // Include all Vico modules as implementation dependencies
    api(project(":vico:core"))
    api(project(":vico:compose"))
    api(project(":vico:compose-m2"))
    api(project(":vico:compose-m3"))
    api(project(":vico:views"))
    
    // Required Compose dependencies
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material:material:1.5.4")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                
                groupId = "com.patrykandpatrick.vico"
                artifactId = "vico"
                version = Versions.VICO

                pom {
                    name.set("Vico Enhanced")
                    description.set("A light and extensible chart library for Android with column click functionality")
                    url.set("https://github.com/husseinyehya687/vico")
                    
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    
                    developers {
                        developer {
                            id.set("husseinyehya687")
                            name.set("Hussein Yehya")
                            email.set("husseinyehya687@gmail.com")
                        }
                        developer {
                            id.set("patrykgoworowski")
                            name.set("Patryk Goworowski")
                        }
                        developer {
                            id.set("patrick-michalik")
                            name.set("Patrick Michalik")
                        }
                    }
                    
                    scm {
                        connection.set("scm:git:git://github.com/husseinyehya687/vico.git")
                        developerConnection.set("scm:git:ssh://github.com:husseinyehya687/vico.git")
                        url.set("https://github.com/husseinyehya687/vico/tree/main")
                    }
                }
            }
        }
    }
}

subprojects.forEach { it.tasks.withType<Test>().configureEach { useJUnitPlatform() } }