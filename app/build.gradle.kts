
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.dafan.aiagent"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dafan.aiagent"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
