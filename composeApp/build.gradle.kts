import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinxSerialization) apply false

}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    jvm("desktop")
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }



        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation("tech.annexflow.compose:constraintlayout-compose-multiplatform:0.3.0-alpha01")

            implementation("androidx.compose.foundation:foundation:1.7.3")


            implementation(libs.coil.compose.core)
            implementation(libs.coil.mp)
            implementation(libs.coil.network.ktor)
            implementation(libs.coil.compose)

            implementation(libs.kotlin.coroutines)
            implementation(libs.stately.common)

            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.composeVM)
            implementation(libs.lifecycle.viewmodel.compose)


            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screen.model)
            implementation(libs.voyager.transitions)
            implementation(libs.voyager.koin)

            implementation(libs.multiplatform.settings.no.arg)
            implementation(libs.multiplatform.settings.coroutines)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.logging)


            implementation(libs.kotlinx.datetime)

        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation(libs.ktor.client.okhttp)
        }
    }
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

compose.desktop {
    application {
        mainClass = "org.example.project.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}
