plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.mephistolie.compost.library")
    id("maven-publish")
}

dependencies {
    implementation(libs.compose.runtime)
    implementation(project(":core"))
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = libs.versions.groupId.get()
                artifactId = "ui"
                version = libs.versions.version.get()

                from(components["release"])
            }
        }
    }
}
