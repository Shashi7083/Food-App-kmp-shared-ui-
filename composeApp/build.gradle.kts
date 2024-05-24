//import dev.icerock.gradle.MRVisibility
//import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
//    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
//            export("dev.icerock.moko:resources:0.23.0")
//            export("dev.icerock.moko:graphics:0.9.0") // toUIColor here
            isStatic = true
        }
    }


    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.image.loader)
            implementation("dev.icerock.moko:resources:0.23.0")
            implementation("dev.icerock.moko:resources-compose:0.23.0") // for compose multiplatform
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
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

compose.resources{
    publicResClass = true
    packageOfResClass = "org.example.project.resources"
    generateResClass = always
}

//multiplatformResources{
//    multiplatformResourcesPackage = "org.example.project"
//    multiplatformResourcesClassName = "composeResources"
//}

//multiplatformResources {
//    multiplatformResourcesPackage = "org.example.project" // required
//    multiplatformResourcesClassName = "SharedRes" // optional, default MR
//    multiplatformResourcesVisibility = MRVisibility.Internal // optional, default Public
//    iosBaseLocalizationRegion = "en" // optional, default "en"
//    multiplatformResourcesSourceSet = "commonMain"  // optional, default "commonMain"
//}