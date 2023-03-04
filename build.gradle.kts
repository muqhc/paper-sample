plugins {
    kotlin("jvm") version "1.8.0"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    
    implementation("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
}

tasks.processResources {
    val apiVersion = rootProject.providers.gradleProperty("mcVersion").get()
        .split(".", "-").take(2).joinToString(".")
    val props = mapOf(
        "version" to project.version,
        "apiVersion" to apiVersion,
        "pluginName" to project.name.split('-').joinToString("") { it.capitalize() },
        "group" to (project.group as String)
        
    )
    inputs.properties(props)
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}


