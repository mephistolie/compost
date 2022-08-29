object Dependencies {

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.8.0"
        const val activityCompose = "androidx.activity:activity-compose:1.5.1"
    }

    object Compose {
        const val version = "1.2.0"
        private const val runtimeVersion = "1.2.1"
        private const val uiVersion =  "1.2.1"
        private const val materialVersion = "1.2.1"

        const val runtime = "androidx.compose.runtime:runtime:$runtimeVersion"
        const val ui = "androidx.compose.ui:ui:$uiVersion"
        const val material = "androidx.compose.material:material:$materialVersion"
    }

    object Accompanist {
        private const val accompanistVersion = "0.25.1"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"
        const val pager = "com.google.accompanist:accompanist-pager:$accompanistVersion"
    }

}