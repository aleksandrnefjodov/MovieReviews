object Dependencies {
    const val kotlin = "androidx.core:core-ktx:${Versions.kotlin}"

    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Dagger - Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val hiltAndroidCompiler =  "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val hiltCompiler =  "androidx.hilt:hilt-compiler:1.0.0"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:1.0.0"

    // Coroutines
    const val courutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val courutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //Tests
    const val junit = "junit:junit:${Versions.junit}"
    const val testCoreKtx = "androidx.test:core-ktx:1.5.0"
    const val archCoreTesting = "androidx.arch.core:core-testing:2.1.0"
    const val courutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val truth = "com.google.truth:truth:1.1.3"
    const val hiltTest = "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
}