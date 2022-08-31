plugins {
    id("com.mephistolie.compost.library")
    id("maven-publish")
}

detekt {
    allRules = true
    parallel = true
    config = files("$rootDir/detekt/library-config.yml")
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
