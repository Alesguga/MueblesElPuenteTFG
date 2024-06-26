plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "net.azarquiel.logintfg"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.azarquiel.logintfg"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.material3:material3:1.3.0-alpha06")
    implementation("androidx.wear.compose:compose-material:1.3.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.runtime:runtime-livedata:1.6.7")
    implementation("com.google.firebase:firebase-appcheck-playintegrity:18.0.0")
    testImplementation("junit:junit:4.13.2")
    //Preview y tooling
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.7")
    implementation ("androidx.compose.ui:ui-tooling:1.6.7")
    //Firebase Auth
    implementation("com.google.firebase:firebase-auth:23.0.0")
    //Firebase Firestore
    implementation("com.google.firebase:firebase-firestore-ktx:25.0.0")
    //Firebase Storage
    implementation("com.google.firebase:firebase-storage-ktx:21.0.0")
    //Firebase Realtime Database
    implementation("com.google.firebase:firebase-database-ktx:21.0.0")
    //Splash Api
    implementation ("androidx.core:core-splashscreen:1.0.1")
    //Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")
    //Coil
    implementation ("io.coil-kt:coil-compose:2.4.0")
    //Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")
    //Glance
    implementation ("androidx.glance:glance-appwidget:1.0.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}