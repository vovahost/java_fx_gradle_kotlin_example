import org.gradle.internal.jvm.Jvm

repositories {
    mavenCentral()
}

plugins {
    java
    application
    kotlin("jvm") version "1.4.0"
    // https://openjfx.io/openjfx-docs/#modular
    id("org.openjfx.javafxplugin") version "0.0.9"
}

val currentJvm: Jvm = Jvm.current()
println("currentJvm : $currentJvm")

javafx {
    version = "14"
    // https://stackoverflow.com/a/52907749/1502079
    modules = listOf("javafx.controls", "javafx.media", "javafx.web", "javafx.swing", "javafx.fxml")

}

group = "com.example"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "com.example.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("junit", "junit", "4.12")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}