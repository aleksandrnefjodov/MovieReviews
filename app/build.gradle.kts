plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-parcelize")
}

android {
    namespace  = "com.example.moviereviews"
    compileSdk  = ConfigData.targetSdkVersion

    defaultConfig {
        applicationId = "com.example.moviereviews"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        buildConfigField ("String", "API_KEY", "\"JmjSMxyiJg2QhNQiTu4biTLKah5WzcAb\"")

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation (Dependencies.kotlin)
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation (Dependencies.lifecycleLiveData)
    implementation (Dependencies.lifecycleViewModel)
    implementation (Dependencies.navigationFragment)
    implementation (Dependencies.navigationUI)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Coroutines
    implementation (Dependencies.courutinesCore)
    implementation (Dependencies.courutinesAndroid)

    //Dagger - Hilt
    implementation (Dependencies.hilt)
    implementation (Dependencies.hiltNavigation)
    kapt (Dependencies.hiltAndroidCompiler)
    kapt (Dependencies.hiltCompiler)

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    kapt ("com.github.bumptech.glide:compiler:4.12.0")

    //Paging
    implementation ("androidx.paging:paging-runtime-ktx:3.1.1")

    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")

    testImplementation (Dependencies.junit)
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}