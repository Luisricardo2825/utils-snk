plugins {
    id("java")
    id("application")
}

group = "com.sankhya.ce"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
    implementation(fileTree("libs"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


tasks {
    jar {
        archiveBaseName.set("UtilsSNK")
        archiveVersion.set("0.1.1")

        dependencies {
            implementation(fileTree("libs"))
        }
    }
}
