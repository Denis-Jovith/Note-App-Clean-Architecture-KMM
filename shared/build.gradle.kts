import org.gradle.declarative.dsl.schema.FqName.Empty.packageName
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight) // Add SQLDelight plugin
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Place multiplatform dependencies here
            implementation(libs.runtime)
            implementation(libs.kotlinx.datetime)
            implementation(libs.sqldelight.runtime) // Add SQLDelight runtime dependency
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.android.driver)
            implementation(libs.sqldelight.android.driver) // Add SQLDelight Android driver
        }
        iosMain.dependencies {
            implementation(libs.native.driver)
            implementation(libs.sqldelight.native.driver) // Add SQLDelight native driver
        }
    }
}

sqldelight {
    database("NoteDatabase") {
        packageName = "com.example.noteappkmmcleancode.android" // Replace with your package name
        sourceFolders = listOf("sqldelight")
    }
}

android {
    namespace = "com.example.noteappkmmcleancode"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}