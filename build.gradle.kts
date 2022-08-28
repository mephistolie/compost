buildscript {

    val groupId by extra("com.github.mephistolie")
    val libraryVersion by extra("0.0.1")

    val minSdk by extra(21)
    val targetSdk by extra(33)
    val compileSdk by extra(33)

    val composeVersion by extra("1.2.0")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {

        val gradleVersion by extra( "7.2.2")
        val kotlinVersion by extra("1.7.0")

        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
