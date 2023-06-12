plugins {
    id("org.jetbrains.intellij") version "1.13.3"
    kotlin("jvm") version "1.7.20"
    java
}

group = "dev.jstanger"
version = "0.4.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2023.1")
}
tasks {
    patchPluginXml {
        changeNotes.set("""`
            Add full character support to keys""".trimIndent())
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

sourceSets["main"].java.srcDirs("src/main/gen")