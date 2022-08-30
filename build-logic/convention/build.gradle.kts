plugins {
    `kotlin-dsl`
}

group = "com.mephistolie.compost.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("compostLibrary") {
            id = "com.mephistolie.compost.library"
            implementationClass = "CompostLibraryModuleConventionPlugin"
        }
        register("compostApplication") {
            id = "com.mephistolie.compost.application"
            implementationClass = "CompostApplicationModuleConventionPlugin"
        }
    }
}
