// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version Versions.gradlePlugin apply false
    id ("com.android.library") version Versions.gradlePlugin apply false
    id ("org.jetbrains.kotlin.android") version Versions.kotlin apply false
    id ("com.google.dagger.hilt.android") version Versions.daggerHilt apply false
    id ("androidx.navigation.safeargs") version "2.5.3" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}