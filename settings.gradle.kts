enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google() // Required for Android dependencies
        gradlePluginPortal() // For Gradle plugins
        mavenCentral() // For other dependencies
    }
}

dependencyResolutionManagement {
    repositories {
        google()  // Required for Android dependencies like androidx.appcompat
        mavenCentral()  // Required for other dependencies
    }

}

rootProject.name = "NoteAppKMMCleanCode"
include(":androidApp")
include(":shared")
