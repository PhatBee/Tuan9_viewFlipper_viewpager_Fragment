plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "vn.phatbee.tuan9_viewflipper_viewpager_fragment"
    compileSdk = 35

    defaultConfig {
        applicationId = "vn.phatbee.tuan9_viewflipper_viewpager_fragment"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.glide)
    annotationProcessor(libs.glideAnnotation)
    implementation(libs.circleindicator)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.android.image.slider)
}

