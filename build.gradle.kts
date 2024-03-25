/*
 * Copyright (C) 2010-2022, Danilo Pianini and contributors
 * listed, for each module, in the respective subproject's build.gradle.kts file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */
plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.java.qa)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.multiJvmTesting)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.taskTree)
}

group = "it.unibo.alchemist"

repositories {
    mavenCentral()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        content {
            includeGroup("no.tornado")
        }
    }
}

multiJvm {
    jvmVersionForCompilation.set(17)
}

kotlin {
    target {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }
}

dependencies {
    compileOnly(libs.spotbugs.annotations)
    api(libs.bundles.alchemist)
    implementation(libs.bundles.jiconfont)
    implementation(libs.apache.commons.collections4)
    implementation(libs.controlsfx)
    implementation(libs.gson.extras)
    implementation(libs.guava)
    implementation(libs.javafxSvg)
    implementation(libs.jfoenix)
    implementation(libs.leafletmap)
    implementation(libs.resourceloader)
    implementation(libs.slf4j)
    implementation(libs.tornadofx)
    val javaFXVersion = "11"
    for (platform in listOf("linux", "mac", "win")) {
        api("org.openjfx:javafx-base:$javaFXVersion:$platform")
        api("org.openjfx:javafx-controls:$javaFXVersion:$platform")
        api("org.openjfx:javafx-fxml:$javaFXVersion:$platform")
        api("org.openjfx:javafx-graphics:$javaFXVersion:$platform")
        api("org.openjfx:javafx-media:$javaFXVersion:$platform")
        api("org.openjfx:javafx-swing:$javaFXVersion:$platform")
        api("org.openjfx:javafx-web:$javaFXVersion:$platform")
    }
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
    testRuntimeOnly(libs.alchemist.incarnation.protelis)
}

tasks.javadoc {
    enabled = false
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
        showCauses = true
        showStackTraces = true
        events(*org.gradle.api.tasks.testing.logging.TestLogEvent.values())
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
}

publishOnCentral {
    projectLongName.set(project.properties["projectLongName"] as String)
    projectDescription.set(project.properties["projectDescription"] as String)
    scmConnection.set("scm:git:https://github.com/AlchemistSimulator/alchemist-fxui")
    projectUrl.set("https://github.com/AlchemistSimulator/alchemist-fxui")
}

publishing.publications {
    withType<MavenPublication> {
        pom {
            developers {
                developer {
                    name.set("Niccolò Maltoni")
                    email.set("niccolo.maltoni@studio.unibo.it")
                }
                developer {
                    name.set("Vuksa Mihajlovic")
                    email.set("vuksa.mihajlovic@studio.unibo.it")
                }
                developer {
                    name.set("Danilo Pianini")
                    email.set("danilo.pianini@unibo.it")
                }
            }
        }
    }
}
