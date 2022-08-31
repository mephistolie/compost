plugins {
    id("com.mephistolie.compost.application")
}

detekt {
    allRules = true
    parallel = true
    config = files("$rootDir/detekt/application-config.yml")
}
