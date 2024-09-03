plugins {
    id("java")
    id("application")
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Luisricardo2825/UtilsSNK")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GPRUSER")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GPRKEY")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

group = "com.sankhya.ce"
version = "1.0-snapshot"

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
        archiveVersion.set("1.0-snapshot")
        dependencies {
            implementation(fileTree("libs"))
        }
    }
}
