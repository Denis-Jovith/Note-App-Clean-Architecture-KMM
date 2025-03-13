plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
    alias(libs.plugins.compose.compiler) // Add Compose Compiler Plugin
}

android {
    namespace = "com.example.noteappkmmcleancode.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.noteappkmmcleancode.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler")
    stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
}

repositories {
    google() // Required for Android dependencies (like androidx.appcompat)
    mavenCentral() // Required for other dependencies
}

dependencies {
    implementation(project(":shared"))

    // Jetpack Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    // Core Library Desugaring
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    // KotlinX Datetime
    implementation(libs.kotlinx.datetime)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.android.compiler)

    // AndroidX Dependencies
    implementation(libs.androidx.appcompat.v170)  // Specify a valid version
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Hilt Navigation Compose
    implementation(libs.androidx.hilt.navigation.compose)

    // Dagger Dependencies
    kapt(libs.dagger.compiler) // Required for annotation processing
    implementation(libs.dagger.v244)
    kapt(libs.dagger.compiler.v244)
}
