import com.android.build.gradle.LibraryExtension
import com.mephistolie.compost.configureCompostCommonModule
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class CompostLibraryModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply(libs.findPlugin("android-library").get().get().pluginId)
            pluginManager.apply(libs.findPlugin("kotlin-android").get().get().pluginId)

            extensions.configure<LibraryExtension> {
                configureCompostCommonModule(this)
                defaultConfig.targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
            }
        }
    }
}
