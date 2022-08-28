plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    compileSdk = rootProject.extra.get("compileSdk") as Int

    defaultConfig {
        minSdk = rootProject.extra.get("minSdk") as Int
        targetSdk = rootProject.extra.get("targetSdk") as Int
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra.get("composeVersion") as String
    }
}

dependencies {
    val composeVersion: String by rootProject.extra
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")

    val shimmerVersion = "1.0.3"
    api("com.valentinilk.shimmer:compose-shimmer:$shimmerVersion")

    val reorderableVersion = "0.9.2"
    api("org.burnoutcrew.composereorderable:reorderable:$reorderableVersion")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = rootProject.extra.get("groupId") as String
                artifactId = "compost-core"
                version = rootProject.extra.get("libraryVersion") as String

                from(components["release"])
            }
        }
    }
}
