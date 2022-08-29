pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Compost"

include(":ui")
include(":core")
include(":demo")
