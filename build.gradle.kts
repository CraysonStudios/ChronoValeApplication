plugins {
    kotlin("jvm") version "2.2.20-Beta2"
    id("com.gradleup.shadow") version "8.3.0"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "dev.crayson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven {
        name = "Translations"
        url = uri("https://nexus.leonardbausenwein.de/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.triumphteam.dev/snapshots/")
    }
}

val lampVersion = "4.0.0-rc.10"
dependencies {

    implementation("net.kyori:adventure-text-minimessage:4.24.0")
    implementation("net.kyori:adventure-text-serializer-plain:4.24.0")
    implementation("net.kyori:adventure-text-serializer-legacy:4.24.0")


    // Commands
    implementation("io.github.revxrsal:lamp.common:${lampVersion}")
    implementation("io.github.revxrsal:lamp.bukkit:${lampVersion}")

    // Guis
    implementation("dev.triumphteam:triumph-gui-paper:3.1.13-SNAPSHOT")

    // Translations
    api("de.cubbossa:TinyTranslations-paper:4.5.0")

    implementation("org.slf4j:slf4j-api:2.0.13")

    compileOnly("io.papermc.paper:paper-api:1.21.6-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks {
    runServer {
        minecraftVersion("1.21")
    }
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}
