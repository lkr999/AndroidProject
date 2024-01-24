pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven ("https://download2.dynamsoft.com/maven/aar")
//        maven ("http://jitpack.io")
    }
}

rootProject.name = "WH_transfer"
include(":app")
 