plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // Required for Firebase services
}

android {
    namespace = "com.example.firebase"
    compileSdk = 35  // Android 34 is stable; 35 is preview-only.

    defaultConfig {
        applicationId = "com.example.firebase"
        minSdk = 24
        targetSdk = 35  // Ensure compatibility with stable versions.
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
        sourceCompatibility = JavaVersion.VERSION_17  // Update to Java 17 for latest features
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Firebase BOM (Manages versions automatically)
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))

    // Firebase Services
    implementation("com.google.firebase:firebase-auth")       // Authentication
    implementation("com.google.firebase:firebase-firestore")  // Firestore Database
    implementation("com.google.firebase:firebase-database")   // Realtime Database (if needed)
    implementation("com.google.firebase:firebase-storage")    // Firebase Storage (optional)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
