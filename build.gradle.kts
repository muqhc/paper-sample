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




