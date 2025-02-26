plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.screenshot)
}

android {
    namespace = "soy.gabimoreno.androidxrexample"
    compileSdk = 35

    defaultConfig {
        applicationId = "soy.gabimoreno.androidxrexample"
        minSdk = 34
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        compose = true
    }
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.impress)
    implementation(libs.androidx.arcore)
    implementation(libs.androidx.scenecore)
    implementation(libs.androidx.compose)
    implementation(libs.kotlinx.coroutines.guava)

    implementation(libs.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.adaptive.android)
    implementation(libs.androidx.concurrent.futures)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.activity.compose)

    debugImplementation(libs.androidx.compose.ui.tooling)

    screenshotTestImplementation(libs.androidx.compose.ui.tooling)
}
