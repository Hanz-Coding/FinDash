plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.room)
//    alias(libs.plugins.firebase)
    alias(libs.plugins.ksp)
}

android {
    namespace = "hanz.coding.findash"
    compileSdk = 35

    defaultConfig {
        applicationId = "hanz.coding.findash"
        minSdk = 24
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
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }

    sourceSets["main"].java.srcDirs("build/generated/ksp/main/kotlin")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.firebase.auth)
    implementation(libs.play.services.auth)
    implementation(libs.androidx.credentials.core)
    implementation(libs.androidx.credentials.service)
    implementation(libs.googleid)
    ksp(libs.androidx.room.compiler)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(libs.bundles.koin)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.coil)
    implementation(platform(libs.firebase.bom))

    implementation(libs.bundles.ktor)
    implementation(libs.timber)

    testImplementation(libs.junit)
    testImplementation(libs.mokk)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.mokk.android)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}