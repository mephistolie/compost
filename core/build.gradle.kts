plugins {
    id("com.mephistolie.compost.library")
    id("maven-publish")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = libs.versions.groupId.get()
                artifactId = "core"
                version = libs.versions.version.get()

                from(components["release"])
            }
        }
    }
}
