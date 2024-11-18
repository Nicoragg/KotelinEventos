plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.agendadeeventos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.agendadeeventos"
        minSdk = 23
        targetSdk = 35
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
    // Core libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Activity Compose support
    implementation(libs.androidx.activity.compose)

    // Compose BOM and libraries
    implementation(platform(libs.androidx.compose.bom)) // Usa a BOM para definir as versões do Compose
    implementation(libs.androidx.ui) // UI do Compose
    implementation(libs.androidx.ui.graphics) // Gráficos no Compose
    implementation(libs.androidx.ui.tooling.preview) // Ferramentas de visualização no Compose
    implementation(libs.androidx.material3) // Material 3

    // Navigation for Compose
    implementation("androidx.navigation:navigation-compose:2.6.0") // Navegação para Compose

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Usa o BOM para testes
    androidTestImplementation(libs.androidx.ui.test.junit4) // Testes para Compose

    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling) // Ferramentas de depuração
    debugImplementation(libs.androidx.ui.test.manifest) // Testes de manifestos do Compose
}