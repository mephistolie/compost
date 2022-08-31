import com.android.build.api.dsl.ApplicationExtension
import com.mephistolie.compost.configureCompostCommonModule
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class CompostApplicationModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply(libs.findPlugin("android-application").get().get().pluginId)
            pluginManager.apply(libs.findPlugin("kotlin-android").get().get().pluginId)

            extensions.configure<ApplicationExtension> {
                configureCompostCommonModule(this)

                defaultConfig {
                    applicationId = libs.findVersion("applicationId").get().toString()
                    targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
                    versionCode = libs.findVersion("versionCode").get().toString().toInt()
                    versionName = libs.findVersion("version").get().toString()

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                dependencies {
                    add("implementation", libs.findLibrary("androidx.core").get())
                    add("implementation", libs.findLibrary("androidx.activity.compose").get())

                    add("implementation", libs.findLibrary("accompanist.systemUiController").get())
                    add("implementation", libs.findLibrary("accompanist.pager").get())

                    add("implementation", project(":core"))
                    add("implementation", project(":ui"))
                }
            }
        }
    }
}
