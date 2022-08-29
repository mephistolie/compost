buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Config.gradleClasspath)
        classpath(Config.kotlinClasspath)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
