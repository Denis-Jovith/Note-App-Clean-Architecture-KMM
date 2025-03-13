plugins {
    // Apply Android and Kotlin plugins globally but only in sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)

    // Compose plugin for Compose-based UI projects
    alias(libs.plugins.compose.compiler).apply(false)

}
