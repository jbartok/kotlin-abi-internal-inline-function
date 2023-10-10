plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":target"))
    implementation("org.jetbrains.kotlin:kotlin-build-tools-api:1.9.20-Beta2")
    runtimeOnly("org.jetbrains.kotlin:kotlin-build-tools-impl:1.9.20-Beta2")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

application {
    mainClass.set("com.gradle.abi.RunnerKt")
}
